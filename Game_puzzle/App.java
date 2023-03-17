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
    private JButton btnPlay;
    private JButton[] btnpuzzle;
    private JTextField tfAnswer;
    private JButton btnSubmit;
    private JLabel lbScore;
    private JButton btnNewGame;
    private Icon imgBackground;

    private int width, height;
    // private Boolean isClicked = false;
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

    public App() {
        f = new JFrame("Game Puzzle");
        f.setSize(500, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        detailComponents();
    }

    private void detailComponents() {
        // import a image
        try {
            // Select game mode
            String[] modes = { "Easy mode", "Normal mode", "Hard mode" };
            int selectedMode = JOptionPane.showOptionDialog(null, "Easy = 4 tables\nNormal = 9 tables\nHard = 9 tables",
                    "Mode Selector",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, modes, modes[0]);

            if (selectedMode == 0) {
                f.setVisible(true);
                modeEasy();
                mode = "Easy";
                tables = 4;
                life = 7;
                width = 200;
                height = 200;
                System.out.println("Easy mode");
            } else if (selectedMode == 1) {
                f.setVisible(true);
                modeNormal();
                mode = "Normal";
                tables = 9;
                life = 5;
                width = 134;
                height = 134;
                System.out.println("Normal mode");
            } else if (selectedMode == 2) {
                f.setVisible(true);
                modeHard();
                mode = "Hard";
                tables = 9;
                life = 3;
                width = 134;
                height = 134;
                System.out.println("Hard mode");
            }
            // image Backgroud
            imgBackground = new ImageIcon("Game_puzzle/picture/background/image_part_001.jpg");

        } catch (Exception e) {
            System.out.println(e);
        }

        // declare
        lbNameGame = new JLabel("MODE: " + mode, SwingConstants.CENTER);
        btnPlay = new JButton("Play");
        btnNewGame = new JButton("New Game");
        lbScore = new JLabel("");
        btnpuzzle = new JButton[tables];
        btnSubmit = new JButton("Submit");
        tfAnswer = new JTextField("", 20);
        lifeSave = life;

        // Set size
        lbNameGame.setPreferredSize(new Dimension(400, 50));
        lbNameGame.setFont(new Font("Serif", Font.PLAIN, 35));
        lbNameGame.setForeground(Color.GREEN);
        tfAnswer.setPreferredSize(new Dimension(150, 20));
        btnSubmit.setPreferredSize(new Dimension(150, 20));
        btnPlay.setPreferredSize(new Dimension(100, 50));
        btnNewGame.setPreferredSize(new Dimension(100, 50));
        lbScore.setPreferredSize(new Dimension(200, 50));

        // add variable into frame
        f.setLayout(new FlowLayout());
        f.add(lbNameGame);
        for (int i = 0; i < tables; i++) {
            btnpuzzle[i] = new JButton();
            btnpuzzle[i].setPreferredSize(new Dimension(width, height));
            f.add(btnpuzzle[i]);
        }
        f.add(tfAnswer);
        f.add(btnSubmit);
        f.add(lbScore);
        f.add(btnPlay);
        f.add(btnNewGame);

        // Class add function button
        AllButtonsListener1 b1 = new AllButtonsListener1();
        btnPlay.addActionListener(b1);
        btnNewGame.addActionListener(b1);
        for (int i = 0; i < tables; i++) {
            btnpuzzle[i].addActionListener(b1);
        }

        // Class add function check the answer
        ChecktheAnswer c1 = new ChecktheAnswer();
        tfAnswer.addActionListener(c1);
        btnSubmit.addActionListener(c1);

        // Play game
        newGame();
    }

    // function new game
    public void newGame() {
        life = lifeSave;
        cnt = 0;
        createPuzzle();
        play();
        if (mode == "Easy")
            modeEasy();
        else if (mode == "Normal")
            modeNormal();
        else if (mode == "Hard")
            modeHard();
    }

    // function createPuzzle
    protected void createPuzzle() {
        for (int i = 0; i < tables; i++) {
            btnpuzzle[i].setIcon(imgBackground);
        }
    }

    // function play
    protected void play() {
        lbScore.setText("Score: " + score + "\n Guess: " + guess + "\n Life: " + life); // show score, guess and life
        tfAnswer.setText(""); // เคลียร์ช่องคำตอบ
        score = 0;
        guess = 0;
    }

    // function Game Over
    protected void gameOver() {
        String gg = "Game Over!!!\n" + "YourScore: " + score + "\nGuess: " + guess;
        JOptionPane.showMessageDialog(null, gg, "Thank for playing!", 2);
        newGame();
    }

    private void random() {
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        question = a + " + " + b + " = ?";
        answerrr = a + b;
    }

    private void quiz(int idx) {
        random();
        // คำถาม
        String ans = JOptionPane.showInputDialog(null, "" + question + "", "The Question", 1);
        try {
            if (answerrr == Integer.parseInt(ans)) {
                // ตอบถูก
                JOptionPane.showMessageDialog(null, "You're Correct!!!", "The Answer", 1);
                // ทำอะไรต่อ เช่นเปิดแผ่านป่ายได้
                btnpuzzle[idx].setIcon(imgPuzzle(idx));
                guess++;
                cnt++;
                play();
            } else if (answerrr != Integer.parseInt(ans)) {
                // ตอบผิด
                guess++;
                life--;
                JOptionPane.showMessageDialog(null, "You're Wrong!!!\nPlease input the answer again.", "The Answer", 1);
                play();
                if (life < 1) {
                    gameOver();
                }
            }

        } catch (Exception e) {

        }
    }

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

    public void sound(String srcSound){
       try{
            File file = new File(srcSound);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
            clip.start();
       } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1){

       }
    }

    // class for check the answer
    private class ChecktheAnswer implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s = tfAnswer.getText();
            // สำหรับการ test
            if (s.toUpperCase().equals("HACK")) {
                JOptionPane.showMessageDialog(null, answer, "Cheat", 3);
                life = 99;
                play();
            } else if (s.toUpperCase().equals("SHOWALL")) {
                for (int idx = 0; idx < tables; idx++) {
                    btnpuzzle[idx].setIcon(imgPuzzle(idx));
                }
            }
            // ถ้าชีวิตหมดก็จบเกม
            else if (life < 2) {
                gameOver();
            } else {
                if (s.toUpperCase().equals(showAnswer())) {
                    score++;
                    JOptionPane.showMessageDialog(null, "You're Correct!!!", "The Answer", 1); // popup
                    sound("Game_puzzle/Music/correct.wav");
                    newGame();
                } else if (!s.toUpperCase().equals(showAnswer()) && !s.equals("")) {
                    life--;
                    JOptionPane.showMessageDialog(null, "You're Wrong!!!", "The Answer", 1);
                    sound("Game_puzzle/Music/wrong.wav");
                    play();
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
                if (source == btnPlay) {
                    sound("Game_puzzle/Music/red.wav");
                }
                if (source == btnNewGame) {
                    newGame();
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
                // System.out.println(e);
            }

        }
    }
}
