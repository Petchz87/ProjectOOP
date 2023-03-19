package Game_puzzle;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class modeGamePlay {
    protected Icon[] imgEasy = new Icon[4];
    protected Icon[] imgNormalHard = new Icon[9];
    String[] puzzle = { "ALLIGATOR", "BIRD", "CAT", "CHICKEN", "DINOSAUR", "DOG", "DUCK", "FOX", "PIG", "SNAKE", "WOLF"};
    String[] puzzle2 = { "BEAR", "DUCK", "ELEPHANT", "FISH", "HORSE", "JELLYFISH", "MONKEY", "PANDA", "PIG", "POLAR", "SHEEP"}; 
    String[] puzzle3 = {"CAMEL", "CAT", "CLAM", "COW", "DOG", "DOPHIN", "ORCA", "HUMAN", "PENGUIN", "TIGER"};
    //Other
    protected String answer;
    protected int tables;
    Random random = new Random();
    private String srcImg = "";

    public void modeEasy(){
        int rd = (int) (Math.random() * 11);
        for (int i = 0; i < tables; i++) {
            srcImg = "Game_puzzle/picture/Easy/" + puzzle[rd] + "/" + (Math.abs(i - tables)) + ".jpg";
            imgEasy[i] = new ImageIcon(srcImg);
        }
        answer = puzzle[rd];
    }

    public void modeNormal(){
        int rd = (int) (Math.random() * 11);
        for (int i = 0; i < tables; i++) {
            srcImg = "Game_puzzle/picture/Normal/" + puzzle2[rd] + "/" + (Math.abs(i - tables)) + ".jpg";
            imgNormalHard[i] = new ImageIcon(srcImg);
        }
        answer = puzzle2[rd];
    }

    public void modeHard(){
        int rd = (int) (Math.random() * 9);
        
        for (int i = 0; i < tables; i++) {
            if(i % 2 == 0){
                int a = random.nextInt(8);
                srcImg = "Game_puzzle/picture/Hard/" + puzzle3[rd] + "/" + (Math.abs(a)) + ".jpg";
            }
            else{
                srcImg = "Game_puzzle/picture/Hard/" + puzzle3[rd] + "/" + (Math.abs(i - tables)) + ".jpg";}
            
            imgNormalHard[i] = new ImageIcon(srcImg);
        }
        answer = puzzle3[rd];
    }

    public String showAnswer(){
        return answer;
    }

}
