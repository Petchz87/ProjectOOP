package Game_puzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import java.util.Random;

public class App extends modeGamePlay {
    // interface
    private JFrame f;
    private JLabel lbNameGame;
    private JButton btnMenu;
    private JButton[] btnpuzzle;
    private JTextField tfAnswer;
    private JButton btnSubmit;
    private JLabel lbScore;
    private JButton btnNewGame;
    private Icon imgBackground;
    private JButton btnSound;
    private int width, height;
    // gameplay
    private int score;
    private int guess;
    private int life;
    private int lifeSave;
    private String mode;
    private int cnt;
    // question
    private String question;
    private int answerrr;
    // sound
    private File file;
    private AudioInputStream audioInput;
    private Clip clip;
    private ImageIcon imgUnmute;
    private ImageIcon imgMute;
    private Boolean BGM_ON = false;
    private Boolean Ismute = false;
    // other
    private Boolean isSelectMode = false;

    public App() {
        f = new JFrame("Game Puzzle");
        f.setSize(500, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        selectedMode();
    }

    private void selectedMode() {
        f.setVisible(false);
        try {
            // Select game mode
            String[] modes = { "Easy mode", "Normal mode", "Hard mode" };
            int selectedMode = JOptionPane.showOptionDialog(null, "Easy = 4 tables\nNormal = 9 tables\nHard = 9 tables",
                    "Mode Selector",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, modes, modes[0]);
            if (selectedMode == 0) {
                mode = "Easy";
                tables = 4;
                life = 5;
                width = 200;
                height = 200;
                isSelectMode = true;
                // System.out.println("Easy mode");
            } else if (selectedMode == 1) {
                mode = "Normal";
                tables = 9;
                life = 4;
                width = 134;
                height = 134;
                isSelectMode = true;
                // System.out.println("Normal mode");
            } else if (selectedMode == 2) {
                mode = "Hard";
                tables = 9;
                life = 3;
                width = 134;
                height = 134;
                isSelectMode = true;
                // System.out.println("Hard mode");
            }
            if (isSelectMode) {
                // image Backgroud
                imgBackground = new ImageIcon("Game_puzzle/picture/background/image_part_001.jpg");
                imgUnmute = new ImageIcon("Game_puzzle/picture/background/unmute.png");
                imgMute = new ImageIcon("Game_puzzle/picture/background/mute.png");
                sound("Game_puzzle/Music/red.wav");
                detailComponents();
                f.setVisible(true);
            } else {
                System.exit(0);
            }
        } catch (Exception e) {
        }
    }

    private void detailComponents() {
        // declare
        lbNameGame = new JLabel("Puzzle of Happiness", SwingConstants.CENTER);
        btnMenu = new JButton("Main Menu");
        btnNewGame = new JButton("New Game");
        lbScore = new JLabel("");
        btnpuzzle = new JButton[tables];
        btnSubmit = new JButton("Submit");
        tfAnswer = new JTextField("", 20);
        btnSound = new JButton(imgUnmute);
        lifeSave = life;

        // Set size
        lbNameGame.setPreferredSize(new Dimension(375, 50));
        lbNameGame.setFont(new Font("Serif", Font.PLAIN, 35));
        lbNameGame.setForeground(Color.PINK);
        tfAnswer.setPreferredSize(new Dimension(150, 20));
        btnSubmit.setPreferredSize(new Dimension(150, 20));
        btnMenu.setPreferredSize(new Dimension(100, 50));
        btnNewGame.setPreferredSize(new Dimension(100, 50));
        lbScore.setPreferredSize(new Dimension(220, 50));
        btnSound.setPreferredSize(new Dimension(40, 40));

        // add variable into frame
        f.setLayout(new FlowLayout());
        f.add(lbNameGame);
        f.add(btnSound);
        for (int i = 0; i < tables; i++) {
            btnpuzzle[i] = new JButton();
            btnpuzzle[i].setPreferredSize(new Dimension(width, height));
            f.add(btnpuzzle[i]);
        }
        f.add(tfAnswer);
        f.add(btnSubmit);
        f.add(lbScore);
        f.add(btnMenu);
        f.add(btnNewGame);

        // Class add function button
        AllButtonsListener1 b1 = new AllButtonsListener1();
        btnMenu.addActionListener(b1);
        btnNewGame.addActionListener(b1);
        btnSound.addActionListener(b1);
        for (int i = 0; i < tables; i++) {
            btnpuzzle[i].addActionListener(b1);
        }

        // Class add function check the answer
        ChecktheAnswer c1 = new ChecktheAnswer();
        tfAnswer.addActionListener(c1);
        btnSubmit.addActionListener(c1);

        // Play game
        newGame();
        playBGM("Game_puzzle/Music/Cute.wav");
    }

    // function new game
    public void newGame() {
        life = lifeSave;
        cnt = 0;
        score = 0;
        guess = 0;
        play();
        createPuzzle();
    }

    // function play
    protected void play() {
        // show score, guess and life
        lbScore.setText("Score: " + score + "\n Guess: " + guess + "\n Life: " + life + "\n Mode: " + mode); //
        tfAnswer.setText(""); // clear the answer
    }

    // function createPuzzle
    protected void createPuzzle() {
        for (int i = 0; i < tables; i++) {
            btnpuzzle[i].setIcon(imgBackground);
        }
        if (mode == "Easy")
            modeEasy();
        else if (mode == "Normal")
            modeNormal();
        else if (mode == "Hard")
            modeHard();
    }

    // fuction show the hidden picture
    private Icon imgPuzzle(int idx) {
        String srcImg = "";
        if (mode == "Easy") {
            return imgEasy[idx];
        } else if (mode == "Normal") {
            return imgNormalHard[idx];
        } else if (mode == "Hard") {
            return imgNormalHard[idx];
        }
        Icon img = new ImageIcon(srcImg);
        return img;
    }

    // function Game Over
    protected void gameOver() {
        if (BGM_ON == true) {
            clip.stop();
        }
        sound("Game_puzzle/Music/GOV.wav");
        String gg = "Game Over!!!\n" + "YourScore: " + score + "\nGuess: " + guess + "\nMode: " + mode
                + "\nThanks for playing :)";
        JOptionPane.showMessageDialog(null, gg, "Nice Try :)", 2);
        if(BGM_ON == true){
            clip.start();
        }
        newGame();
    }

    // function random question
    private void random() {
        Random random = new Random();
        int a = random.nextInt(12);
        int b = random.nextInt(12);
        // int c = random.nextInt(10);
        int op = random.nextInt(3);
        if (op == 0) {
            question = a + " + " + b + " = ?";
            answerrr = a + b;
        } else if (op == 1) {
            question = a + " - " + b + " = ?";
            answerrr = a - b;
        } else if (op == 2) {
            question = a + " x " + b + " = ?";
            answerrr = a * b;
        }
    }

    // function show the question
    private void quiz(int idx) {
        random();
        // Question
        String ans = JOptionPane.showInputDialog(null, "" + question + "", "The Question", 1);
        try {
            if (answerrr == Integer.parseInt(ans)) {
                // Answer is correct
                JOptionPane.showMessageDialog(null, "You're Correct!!!", "The Answer", 1);
                btnpuzzle[idx].setIcon(imgPuzzle(idx));
                guess++;
                cnt++;
                play();
            } else if (answerrr != Integer.parseInt(ans)) {
                // Answer is wrong
                guess++;
                life--;
                JOptionPane.showMessageDialog(null, "You're Wrong!!!\nPlease input the answer again.", "The Answer", 1);
                play();
            }

        } catch (Exception e) {

        }
    }

    // function sound
    public void sound(String srcSound) {
        try {
            File file = new File(srcSound);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f); // Reduce volume by 25 decibels. (-80 - 6)
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
        }
    }

    // function background music
    public void playBGM(String bgm) {
        try {
            file = new File(bgm);
            audioInput = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f); // Reduce volume by 10 decibels.
            if (BGM_ON == true) {
                audioInput.close();
                clip.close();
                clip.stop();
            } else {
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                BGM_ON = true;
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
        }
        BGM_ON = true;
    }

    // class for check the answer
    private class ChecktheAnswer implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s = tfAnswer.getText();
            // for test
            if (s.toUpperCase().equals("HACK")) {
                JOptionPane.showMessageDialog(null, answer, "Cheat on", 3);
                life = 99;
                play();
            } else if (s.toUpperCase().equals("SHOWALL")) {
                for (int idx = 0; idx < tables; idx++) {
                    btnpuzzle[idx].setIcon(imgPuzzle(idx));
                }
                play();
            }
            else {
                // check the answer
                if (s.toUpperCase().equals(showAnswer())) {
                    cnt = 0;
                    score++;
                    guess++;
                    if (BGM_ON == true) {
                        clip.stop();
                    }
                    sound("Game_puzzle/Music/correct.wav");
                    JOptionPane.showMessageDialog(null, "You're Correct!!!", "The Answer", 1); // popup
                    if(BGM_ON == true){
                        clip.start();
                    }
                    createPuzzle();
                    play();
                    if (score == 5) {
                        if (BGM_ON == true) {
                            clip.stop();
                        }
                        sound("Game_puzzle/Music/Win.wav");
                        String gg = "Congratulation!!!\n" + "YourScore: " + score + "\nGuess: " + guess + "\nMode: " + mode
                                + "\nThanks for playing :)";
                        JOptionPane.showMessageDialog(null, gg, "You Win :)", 3);
                        if(BGM_ON == true){
                            clip.start();
                        }
                        newGame();
                    }
                } else if (!s.toUpperCase().equals(showAnswer()) && !s.equals("")) {
                    guess++;
                    life--;
                    sound("Game_puzzle/Music/wrong.wav");
                    JOptionPane.showMessageDialog(null, "You're Wrong!!!", "The Answer", 1);
                    play();
                    // Live end
                    if (life == 0) gameOver();
                }
            }
        }
    }

    // class for each button
    public class AllButtonsListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton) ev.getSource();
            try {
                if (source == btnMenu) {
                    clip.stop();
                    BGM_ON = false;
                    f.remove(lbNameGame);
                    for (int i = 0; i < tables; i++) {
                        f.remove(btnpuzzle[i]);
                    }
                    f.remove(tfAnswer);
                    f.remove(btnSubmit);
                    f.remove(lbScore);
                    f.remove(btnMenu);
                    f.remove(btnNewGame);
                    f.remove(btnSound);
                    isSelectMode = false;
                    Ismute = false;
                    selectedMode();
                }
                if (source == btnNewGame) {
                    newGame();
                }
                if (source == btnSound) {
                    if (Ismute == false) {
                        btnSound.setIcon(imgMute);
                        Ismute = true;
                    } else {
                        btnSound.setIcon(imgUnmute);
                        Ismute = false;
                    }
                    if (BGM_ON == true) {
                        clip.stop();
                        BGM_ON = false;
                    } else {
                        clip.start();
                        BGM_ON = true;
                    }
                }
                if ((source == btnpuzzle[0]) && (cnt != tables)) {
                    quiz(0);
                }
                if ((source == btnpuzzle[1]) && (cnt != tables)) {
                    quiz(1);
                }
                if ((source == btnpuzzle[2]) && (cnt != tables)) {
                    quiz(2);
                }
                if ((source == btnpuzzle[3]) && (cnt != tables)) {
                    quiz(3);
                }
                if ((source == btnpuzzle[4]) && (cnt != tables)) {
                    quiz(4);
                }
                if ((source == btnpuzzle[5]) && (cnt != tables)) {
                    quiz(5);
                }
                if ((source == btnpuzzle[6]) && (cnt != tables)) {
                    quiz(6);
                }
                if ((source == btnpuzzle[7]) && (cnt != tables)) {
                    quiz(7);
                }
                if ((source == btnpuzzle[8]) && (cnt != tables)) {
                    quiz(8);
                }
            } catch (Exception e) {
            }
        }
    }
}
