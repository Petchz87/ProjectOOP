package Game_puzzle;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class App {
    private JFrame f;
    // private JLabel lbLogo;
    private JButton btnPlay;
    private JButton[] btnpuzzle;
    private JTextField tfAnswer;
    private JButton btnSubmit;
    private JLabel lbScore;
    private JButton btnNewGame;
    private Icon img1;
    private Icon imgCat1;
    private Icon imgCat2;
    private Icon imgCat3;
    private Icon imgCat4;
    private Icon imgPuppy1;
    private Icon imgPuppy2;
    private Icon imgPuppy3;
    private Icon imgPuppy4;
    private Icon imgCar1;
    private Icon imgCar2;
    private Icon imgCar3;
    private Icon imgCar4;
    private Icon imgBicycle1;
    private Icon imgBicycle2;
    private Icon imgBicycle3;
    private Icon imgBicycle4;
    private Icon img01bird1;
    private Icon img01bird2;
    private Icon img01bird3;
    private Icon img01bird4;
    private Icon imgBackground;
    private int score;
    private int guess;
    private String answer;
    private Boolean isClicked;
    
    public App(){
        f = new JFrame("Game Puzzle");
        f.setSize(500, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detailComponents();
        
    }

    private void detailComponents() {
        try {
            img1 = new ImageIcon("Game_puzzle/cowboy.png");
            imgBackground = new ImageIcon("Game_puzzle/picture/background/image_part_001.jpg");
            imgCat1 = new ImageIcon("Game_puzzle/picture/cat/image_part_001.jpg");
            imgCat2 = new ImageIcon("Game_puzzle/picture/cat/image_part_002.jpg");
            imgCat3 = new ImageIcon("Game_puzzle/picture/cat/image_part_003.jpg");
            imgCat4 = new ImageIcon("Game_puzzle/picture/cat/image_part_004.jpg");
            imgPuppy1 = new ImageIcon("Game_puzzle/picture/puppy/image_part_001.jpg");
            imgPuppy2 = new ImageIcon("Game_puzzle/picture/puppy/image_part_002.jpg");
            imgPuppy3 = new ImageIcon("Game_puzzle/picture/puppy/image_part_003.jpg");
            imgPuppy4 = new ImageIcon("Game_puzzle/picture/puppy/image_part_004.jpg");
            imgBicycle1 = new ImageIcon("Game_puzzle/picture/bicycle/image_part_001.jpg");
            imgBicycle2 = new ImageIcon("Game_puzzle/picture/bicycle/image_part_002.jpg");
            imgBicycle3 = new ImageIcon("Game_puzzle/picture/bicycle/image_part_003.jpg");
            imgBicycle4 = new ImageIcon("Game_puzzle/picture/bicycle/image_part_004.jpg");
            imgCar1 = new ImageIcon("Game_puzzle/picture/car/image_part_001.jpg");
            imgCar2 = new ImageIcon("Game_puzzle/picture/car/image_part_002.jpg");
            imgCar3 = new ImageIcon("Game_puzzle/picture/car/image_part_003.jpg");
            imgCar4 = new ImageIcon("Game_puzzle/picture/car/image_part_004.jpg");
            img01bird1 = new ImageIcon("Game_puzzle/picture/bird01/image_part_001.jpg");
            img01bird2 = new ImageIcon("Game_puzzle/picture/bird01/image_part_002.jpg");
            img01bird3 = new ImageIcon("Game_puzzle/picture/bird01/image_part_003.jpg");
            img01bird4 = new ImageIcon("Game_puzzle/picture/bird01/image_part_004.jpg");
            
        } catch(Exception e){
            System.out.println(e);
        }
        // lbLogo = new JLabel(img1);
        btnPlay = new JButton("Play");
        btnNewGame = new JButton("New Game");
        btnpuzzle = new JButton[4];
        for (int i = 0; i < 4; i++) {
            btnpuzzle[i] = new JButton(imgBackground);
            btnpuzzle[i].setPreferredSize(new Dimension(200, 200));
            f.add(btnpuzzle[i]);
        }
        lbScore = new JLabel("");
        btnSubmit = new JButton("submit");
        tfAnswer = new JTextField("", 16);
        
        // lbLogo.setPreferredSize(new Dimension(200, 200));
        tfAnswer.setPreferredSize(new Dimension(150, 20));
        btnSubmit.setPreferredSize(new Dimension(150, 20));
        btnPlay.setPreferredSize(new Dimension(100, 50));
        btnNewGame.setPreferredSize(new Dimension(100, 50));
        lbScore.setPreferredSize(new Dimension(200, 50));

        f.setLayout(new FlowLayout());
        // f.add(lbLogo);
        f.add(tfAnswer);
        f.add(btnSubmit);
        f.add(lbScore);
        f.add(btnPlay);
        f.add(btnNewGame);

        AllButtonsListener bl = new AllButtonsListener();
        btnPlay.addActionListener(bl);
        btnNewGame.addActionListener(bl);
        for (int i=0; i < btnpuzzle.length; i++)
        {btnpuzzle[i].addActionListener(bl);}

        ChecktheAnswer b2 = new ChecktheAnswer();
        tfAnswer.addActionListener(b2);
        btnSubmit.addActionListener(b2);


        String[] modes = { "Easy mode", "Hard mode" };
        int selectedMode = JOptionPane.showOptionDialog(null, "Easy = 4 tables\nHard = 9 tables", "Mode Selector",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, modes, modes[0]);

        if (selectedMode == 0) {
            f.setVisible(true);
            System.out.println("Easy mode");
        } else {
            System.out.println("Hard mode");
        }
        newGame();

    }
    private void newGame(){
        score = 0;
        guess = 0;
        tfAnswer.setText("");
        createPuzzle();
        play();
    }
    private void createPuzzle() {
        for (int i = 0; i < 4; i++) {
            btnpuzzle[i].setIcon(imgBackground);
        }
        ans();
    }
    private void play(){
        isClicked = false;
        lbScore.setText("Score: " + score +"\n Guess: " + guess);
        tfAnswer.setText("");
    }
    private Icon ansImg(int idx) {
        Icon ansImg = img1;
        if(answer == "CAT" && idx==0) ansImg = imgCat1;
        if(answer == "CAT" && idx==1) ansImg = imgCat2;
        if(answer == "CAT" && idx==2) ansImg = imgCat3;
        if(answer == "CAT" && idx==3) ansImg = imgCat4;
        else if(answer == "PUPPY"&& idx==0) ansImg = imgPuppy1;
        else if(answer == "PUPPY"&& idx==1) ansImg = imgPuppy2;
        else if(answer == "PUPPY"&& idx==2) ansImg = imgPuppy3;
        else if(answer == "PUPPY"&& idx==3) ansImg = imgPuppy4;
        else if(answer == "BICYCLE" && idx==0) ansImg = imgBicycle1;
        else if(answer == "BICYCLE" && idx==1) ansImg = imgBicycle2;
        else if(answer == "BICYCLE" && idx==2) ansImg = imgBicycle3;
        else if(answer == "BICYCLE" && idx==3) ansImg = imgBicycle4;
        else if(answer == "CAR" && idx==0) ansImg = imgCar1;
        else if(answer == "CAR" && idx==1) ansImg = imgCar2;
        else if(answer == "CAR" && idx==2) ansImg = imgCar3;
        else if(answer == "CAR" && idx==3) ansImg = imgCar4;
        else if (answer == "BIRD" && idx == 0)
            ansImg = img01bird1;
        else if (answer == "BIRD" && idx == 1)
            ansImg = img01bird2;
        else if (answer == "BIRD" && idx == 2)
            ansImg = img01bird3;
        else if (answer == "BIRD" && idx == 3)
            ansImg = img01bird4;
        // if (ans == "cat") {for(int i = 0; i < 4; i++){btnpuzzle[i].setIcon(imgCat[i]);};}
        // if (ans == "puppy") {for(int i = 0; i < 4; i++){btnpuzzle[i].setIcon(imgPuppy[i]);};}
        // if (ans == "bicycle") {for(int i = 0; i < 4; i++){btnpuzzle[i].setIcon(imgBicycle[i]);};}
        // if (ans == "car") {for(int i = 0; i < 4; i++){btnpuzzle[i].setIcon(imgCar[i]);};}
        return ansImg;
    }
       private void ans() {
        String[] puzzle = { "CAT", "PUPPY", "BICYCLE", "CAR", "BIRD" };
        int rd = (int) (Math.random() * 5);
        if (puzzle[rd] == "CAT")
            answer = "CAT";
        else if (puzzle[rd] == "PUPPY")
            answer = "PUPPY";
        else if (puzzle[rd] == "BICYCLE")
            answer = "BICYCLE";
        else if (puzzle[rd] == "CAR")
            answer = "CAR";
        else if (puzzle[rd] == "BIRD")
            answer = "BIRD";

    }
    // class for check the answer
    private class ChecktheAnswer implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String s = tfAnswer.getText();
            // กำหนดให้สามารถทายได้แค่ 20 รอบ
            if(guess == 20){
                String gg = "Game Over!!!\n" + "YourScore: " + score +"\nGuess: " + guess;
                JOptionPane.showMessageDialog(null,gg,"Thank for playing!", 2);
                newGame();
            }
            // เช็คคำตอบว่าใช่ ถ้าใช่ก็ให้เพิ่ม scoreกับguess
            else if(s.toUpperCase().equals(answer)) {
                score++;
                guess++;
                lbScore.setText("Score: " + score +"\n Guess: " + guess); // show score and guess
                JOptionPane.showMessageDialog(null, "You're Correct!!!","The Answer", 1);  // popup 
                isClicked = false;
                tfAnswer.setText(""); // เคลียร์ช่องคำตอบ
                createPuzzle();
            }
            else {
                guess++;
                lbScore.setText("Score: " + score +"\n Guess: " + guess); 
                JOptionPane.showMessageDialog(null, "You're Wrong!!!","The Answer", 1);
                tfAnswer.setText(""); // เคลียร์ช่องคำตอบ
            }
            
        }
    }

    // class for each button  
    private class AllButtonsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton) ev.getSource();
            if ((source == btnpuzzle[0]) && (!isClicked)){
                btnpuzzle[0].setIcon(ansImg(0));
                isClicked = true;
            }else if ((source == btnpuzzle[1]) && (!isClicked)){
                btnpuzzle[1].setIcon(ansImg(1));                
                isClicked = true;
            }else if ((source == btnpuzzle[2]) && (!isClicked)){
                btnpuzzle[2].setIcon(ansImg(2));
                isClicked = true;
            }else if ((source == btnpuzzle[3]) && (!isClicked)){
                btnpuzzle[3].setIcon(ansImg(3));
                isClicked = true;
            }else if (source == btnPlay) {
                guess++;
                play();                
            }else if (source == btnNewGame) {
                newGame();
            }        
        }
    }
}
