package Game_puzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

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

    // gameplay
    private int score;
    private int guess;
    private int life;
    private int lifeSave;
    // private Boolean isClicked;
    private int isClicked; // test
    private String mode;

    public App() {
        f = new JFrame("Game Puzzle");
        f.setSize(500, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                imageEasy();
                mode = "Easy";
                life = 10;
                width = 200;
                height = 200;
                System.out.println("Easy mode");
            } else if (selectedMode == 1) {
                f.setVisible(true);
                imageNormal();
                mode = "Normal";
                life = 3;
                width = 134;
                height = 134;
                System.out.println("Normal mode");
            } else if (selectedMode == 2) {
                f.setVisible(true);
                imageHard();
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
        btnpuzzle = new JButton[tables];
        lbScore = new JLabel("");
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
        AllButtonsListener1 b1 = new AllButtonsListener1(); // for Easy mode
        AllButtonsListener2 b2 = new AllButtonsListener2(); // for Normal & Hard mode
        if (mode == "Easy") {
            btnPlay.addActionListener(b1);
            btnNewGame.addActionListener(b1);
            for (int i = 0; i < btnpuzzle.length; i++) {
                btnpuzzle[i].addActionListener(b1);
            }
        } else {
            btnPlay.addActionListener(b2);
            btnNewGame.addActionListener(b2);
            for (int i = 0; i < btnpuzzle.length; i++) {
                btnpuzzle[i].addActionListener(b2);
            }
        }

        // Class add function check the answer
        ChecktheAnswer c1 = new ChecktheAnswer();
        tfAnswer.addActionListener(c1);
        btnSubmit.addActionListener(c1);

        // Play game
        newGame();

    }

    // function new game
    private void newGame() {
        life = lifeSave;
        score = 0;
        guess = 0;
        tfAnswer.setText("");
        createPuzzle();
        play();
    }

    // function createPuzzle
    private void createPuzzle() {
        for (int i = 0; i < tables; i++) {
            btnpuzzle[i].setIcon(imgBackground);
        }
        ans();
    }

    // function play
    private void play() {
        // isClicked = false;
        isClicked += 1;
        lbScore.setText("Score: " + score + "\n Guess: " + guess + "\n Life: " + life); // show score, guess and life
        tfAnswer.setText(""); // เคลียร์ช่องคำตอบ
    }

    // function image of puzzle
    private Icon imgPuzzle(int idx) {
        String a = answer;
        String ansCapitalize = a.substring(0, 1) + a.substring(1).toLowerCase(); // Capitalize
        String srcImg = "Game_puzzle/picture/" + mode + "/" + ansCapitalize + "/" + (Math.abs(idx - tables)) + ".jpg"; // path
                                                                                                                       // of
                                                                                                                       // answer
                                                                                                                       // image
        Icon img = new ImageIcon(srcImg);
        return img;
    }

    // function random the answer
    private void ans() {
        if (mode == "Easy")
            answerOfEasy();
        else if (mode == "Normal")
            answerOfNormal();
        else
            answerOfHard();
    }

    // function for test
    private void autoplay() {
        isClicked = 99;
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
                autoplay();
            }
            // ถ้าชีวิตหมดก็จบเกม
            else if (life == 0) {
                String gg = "Game Over!!!\n" + "YourScore: " + score + "\nGuess: " + guess;
                JOptionPane.showMessageDialog(null, gg, "Thank for playing!", 2);
                newGame();
            }
            // เช็คคำตอบว่าใช่ ถ้าใช่ก็ให้เพิ่ม scoreกับguess
            else if (s.toUpperCase().equals(answer)) {
                score++;
                guess++;
                JOptionPane.showMessageDialog(null, "You're Correct!!!", "The Answer", 1); // popup
                play();
                createPuzzle();
            } else {
                guess++;
                life--;
                JOptionPane.showMessageDialog(null, "You're Wrong!!!", "The Answer", 1);
                play();
            }
        }
    }
    // class for each button
    private class AllButtonsListener1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton) ev.getSource();
            // if ((source == btnpuzzle[0]) && (!isClicked)) {
            // btnpuzzle[0].setIcon(imgPuzzle(0));
            // isClicked = true;
            // } else if ((source == btnpuzzle[1]) && (!isClicked)) {
            // btnpuzzle[1].setIcon(imgPuzzle(1));
            // isClicked = true;
            // } else if ((source == btnpuzzle[2]) && (!isClicked)) {
            // btnpuzzle[2].setIcon(imgPuzzle(2));
            // isClicked = true;
            // } else if ((source == btnpuzzle[3]) && (!isClicked)) {
            // btnpuzzle[3].setIcon(imgPuzzle(3));
            // isClicked = true;
            // } else if (source == btnPlay) {
            // guess++;
            // play();
            // } else if (source == btnNewGame) {
            // newGame();
            // }
            // TEST
            if ((source == btnpuzzle[0]) && (isClicked > 0)) {
                btnpuzzle[0].setIcon(imgPuzzle(0));
                isClicked--;
            } else if ((source == btnpuzzle[1]) && (isClicked > 0)) {
                btnpuzzle[1].setIcon(imgPuzzle(1));
                isClicked--;
            } else if ((source == btnpuzzle[2]) && (isClicked > 0)) {
                btnpuzzle[2].setIcon(imgPuzzle(2));
                isClicked--;
            } else if ((source == btnpuzzle[3]) && (isClicked > 0)) {
                btnpuzzle[3].setIcon(imgPuzzle(3));
                isClicked--;
            } else if (source == btnPlay) {
                guess++;
                play();
            } else if (source == btnNewGame) {
                newGame();
            }
        }
    }

    private class AllButtonsListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton) ev.getSource();
            // if ((source == btnpuzzle[0]) && (!isClicked)) {
            // btnpuzzle[0].setIcon(imgPuzzle(0));
            // isClicked = true;
            // } else if ((source == btnpuzzle[1]) && (!isClicked)) {
            // btnpuzzle[1].setIcon(imgPuzzle(1));
            // isClicked = true;
            // } else if ((source == btnpuzzle[2]) && (!isClicked)) {
            // btnpuzzle[2].setIcon(imgPuzzle(2));
            // isClicked = true;
            // } else if ((source == btnpuzzle[3]) && (!isClicked)) {
            // btnpuzzle[3].setIcon(imgPuzzle(3));
            // isClicked = true;
            // } else if ((source == btnpuzzle[4]) && (isClicked > 0)) {
            // btnpuzzle[4].setIcon(imgPuzzle(4));
            // isClicked = true;
            // } else if ((source == btnpuzzle[5]) && (isClicked > 0)) {
            // btnpuzzle[5].setIcon(imgPuzzle(5));
            // isClicked = true;
            // } else if ((source == btnpuzzle[6]) && (isClicked > 0)) {
            // btnpuzzle[6].setIcon(imgPuzzle(6));
            // isClicked = true;
            // } else if ((source == btnpuzzle[7]) && (isClicked > 0)) {
            // btnpuzzle[7].setIcon(imgPuzzle(7));
            // isClicked = true;
            // } else if ((source == btnpuzzle[8]) && (isClicked > 0)) {
            // btnpuzzle[8].setIcon(imgPuzzle(8));
            // isClicked = true;
            // } else if (source == btnPlay) {
            // guess++;
            // play();
            // } else if (source == btnNewGame) {
            // newGame();
            // }
            // TEST
            if ((source == btnpuzzle[0]) && (isClicked > 0)) {
                btnpuzzle[0].setIcon(imgPuzzle(0));
                isClicked--;
            } else if ((source == btnpuzzle[1]) && (isClicked > 0)) {
                btnpuzzle[1].setIcon(imgPuzzle(1));
                isClicked--;
            } else if ((source == btnpuzzle[2]) && (isClicked > 0)) {
                btnpuzzle[2].setIcon(imgPuzzle(2));
                isClicked--;
            } else if ((source == btnpuzzle[3]) && (isClicked > 0)) {
                btnpuzzle[3].setIcon(imgPuzzle(3));
                isClicked--;
            } else if ((source == btnpuzzle[4]) && (isClicked > 0)) {
                btnpuzzle[4].setIcon(imgPuzzle(4));
                isClicked--;
            } else if ((source == btnpuzzle[5]) && (isClicked > 0)) {
                btnpuzzle[5].setIcon(imgPuzzle(5));
                isClicked--;
            } else if ((source == btnpuzzle[6]) && (isClicked > 0)) {
                btnpuzzle[6].setIcon(imgPuzzle(6));
                isClicked--;
            } else if ((source == btnpuzzle[7]) && (isClicked > 0)) {
                btnpuzzle[7].setIcon(imgPuzzle(7));
                isClicked--;
            } else if ((source == btnpuzzle[8]) && (isClicked > 0)) {
                btnpuzzle[8].setIcon(imgPuzzle(8));
                isClicked--;
            } else if (source == btnPlay) {
                guess++;
                play();
            } else if (source == btnNewGame) {
                newGame();
            }
        }
    }
}
