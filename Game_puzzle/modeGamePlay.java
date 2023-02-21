package Game_puzzle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class modeGamePlay {
    //Easy
    protected Icon[] imgAligator = new Icon[4];
    protected Icon[] imgBird = new Icon[4];
    protected Icon[] imgCat = new Icon[4];
    protected Icon[] imgChicken = new Icon[4];
    protected Icon[] imgDino = new Icon[4];
    protected Icon[] imgDog = new Icon[4];
    protected Icon[] imgDuck = new Icon[4];
    protected Icon[] imgFox = new Icon[4];
    protected Icon[] imgPig = new Icon[4];
    protected Icon[] imgSnake = new Icon[4];
    protected Icon[] imgWolf = new Icon[4];
    //Normal
    protected Icon[] imgBear = new Icon[4];
    protected Icon[] imgDuck2 = new Icon[4];
    protected Icon[] imgElephant = new Icon[4];
    protected Icon[] imgFish = new Icon[4];
    protected Icon[] imgHorse = new Icon[4];
    protected Icon[] imgJellyFish = new Icon[4];
    protected Icon[] imgMonkey = new Icon[4];
    protected Icon[] imgPig2 = new Icon[4];
    protected Icon[] imgPandaPo = new Icon[4];
    protected Icon[] imgPolar = new Icon[4];
    protected Icon[] imgSheep = new Icon[4];
    //Hard
    protected Icon[] imgCamel = new Icon[9];
    protected Icon[] imgCat2 = new Icon[9];
    protected Icon[] imgClam = new Icon[9];
    protected Icon[] imgCow = new Icon[9];
    protected Icon[] imgDoge = new Icon[9];
    protected Icon[] imgDophin = new Icon[9];
    protected Icon[] imgOrca = new Icon[9];
    protected Icon[] imgOurTeacher = new Icon[9];
    protected Icon[] imgPenguin1 = new Icon[9];
    protected Icon[] imgPenguin2 = new Icon[9];
    protected Icon[] imgTiger = new Icon[9];

    //Other
    protected String answer;

    public void imageEasy(){
        for (int i = 0; i < 4; i++) {
            imgAligator[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Aligator/" + (Math.abs(i-4)) + ".jpg");
            imgBird[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Bird/" + (Math.abs(i-4)) + ".jpg");
            imgCat[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Cat/" + (Math.abs(i-4)) + ".jpg");
            imgChicken[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Chicken/" + (Math.abs(i-4)) + ".jpg");
            imgDino[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Dino/" + (Math.abs(i-4)) + ".jpg");
            imgDog[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Dog/" + (Math.abs(i-4)) + ".jpg");
            imgDuck[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Duck/" + (Math.abs(i-4)) + ".jpg");
            imgFox[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Fox/" + (Math.abs(i-4)) + ".jpg");
            imgPig[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Pig/" + (Math.abs(i-4)) + ".jpg");
            imgSnake[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Snake/" + (Math.abs(i-4)) + ".jpg");
            imgWolf[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Wolf/" + (Math.abs(i-4)) + ".jpg");
        }
    }

    public void imageNormal(){
        for (int i = 0; i < 4; i++) {
            imgBear[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Cat/" + (Math.abs(i-4)) + ".jpg");
            imgDuck2[i] = new ImageIcon();
            imgElephant[i] = new ImageIcon();
            imgFish[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Cat/" + (Math.abs(i-4)) + ".jpg");
            imgHorse[i] = new ImageIcon();
            imgJellyFish[i] = new ImageIcon();
            imgMonkey[i] = new ImageIcon();
            imgPig2[i] = new ImageIcon();
            imgPandaPo[i] = new ImageIcon();
            imgPolar[i] = new ImageIcon();
            imgSheep[i] = new ImageIcon();
        }
    }

    public void imageHard(){
        for (int i = 0; i < 4; i++) {
            imgCamel[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Cat/" + (Math.abs(i-4)) + ".jpg");
            imgCat2[i] = new ImageIcon();
            imgClam[i] = new ImageIcon();
            imgCow[i] = new ImageIcon("C:/Users/Petch/OneDrive/Desktop/Java Y1T2/Gui/Project/ProjectOOP/Game_puzzle/picture/Easy/Cat/" + (Math.abs(i-4)) + ".jpg");
            imgDoge[i] = new ImageIcon();
            imgDophin[i] = new ImageIcon();
            imgOrca[i] = new ImageIcon();
            imgOurTeacher[i] = new ImageIcon();
            imgPenguin1[i] = new ImageIcon();
            imgPenguin2[i] = new ImageIcon();
            imgTiger[i] = new ImageIcon();
        }
    }
    
    public String answerOfEasy() {
        String[] puzzle = { "ALIGATOR", "BIRD", "CAT", "CHICKEN", "DINOSAUR", "DOG", "DUCK", "FOX", "PIG", "SNAKE", "WOLF"};
        int rd = (int) (Math.random() * 11);
        if (puzzle[rd] == "ALIGATOR")
            answer = "ALIGATOR";
        else if (puzzle[rd] == "BIRD")
            answer = "BIRD";
        else if (puzzle[rd] == "CAT")
            answer = "CAT";
        else if (puzzle[rd] == "CHICKEN")
            answer = "CHICKEN";
        else if (puzzle[rd] == "DINOSAUR")
            answer = "DINOSAUR";
        else if (puzzle[rd] == "DOG")
            answer = "DOG";
        else if (puzzle[rd] == "DUCK")
            answer = "DUCK";
        else if (puzzle[rd] == "FOX")
            answer = "FOX";
        else if (puzzle[rd] == "PIG")
            answer = "PIG";
        else if (puzzle[rd] == "SNAKE")
            answer = "SNAKE";
        else if (puzzle[rd] == "WOLF")
            answer = "WOLF";

        return answer;
    }
    public String answerOfNormal() {
        String[] puzzle = { "ALIGATOR", "BIRD", "CAT", "CHICKEN", "DINOSAUR", "DOG", "DUCK", "FOX", "PIG", "SNAKE", "WOLF"};
        int rd = (int) (Math.random() * 5);
        if (puzzle[rd] == "ALIGATOR")
            answer = "ALIGATOR";
        else if (puzzle[rd] == "BIRD")
            answer = "BIRD";
        else if (puzzle[rd] == "CAT")
            answer = "CAT";
        else if (puzzle[rd] == "CHICKEN")
            answer = "CHICKEN";
        else if (puzzle[rd] == "DINOSAUR")
            answer = "DINOSAUR";
        else if (puzzle[rd] == "DOG")
            answer = "DOG";
        else if (puzzle[rd] == "DUCK")
            answer = "DUCK";
        else if (puzzle[rd] == "FOX")
            answer = "FOX";
        else if (puzzle[rd] == "PIG")
            answer = "PIG";
        else if (puzzle[rd] == "SNAKE")
            answer = "SNAKE";
        else if (puzzle[rd] == "WOLF")
            answer = "WOLF";

        return answer;
    }

    public String answerOfHard() {
        String[] puzzle = { "ALIGATOR", "BIRD", "CAT", "CHICKEN", "DINOSAUR", "DOG", "DUCK", "FOX", "PIG", "SNAKE", "WOLF"};
        int rd = (int) (Math.random() * 5);
        if (puzzle[rd] == "ALIGATOR")
            answer = "ALIGATOR";
        else if (puzzle[rd] == "BIRD")
            answer = "BIRD";
        else if (puzzle[rd] == "CAT")
            answer = "CAT";
        else if (puzzle[rd] == "CHICKEN")
            answer = "CHICKEN";
        else if (puzzle[rd] == "DINOSAUR")
            answer = "DINOSAUR";
        else if (puzzle[rd] == "DOG")
            answer = "DOG";
        else if (puzzle[rd] == "DUCK")
            answer = "DUCK";
        else if (puzzle[rd] == "FOX")
            answer = "FOX";
        else if (puzzle[rd] == "PIG")
            answer = "PIG";
        else if (puzzle[rd] == "SNAKE")
            answer = "SNAKE";
        else if (puzzle[rd] == "WOLF")
            answer = "WOLF";

        return answer;
    }
}
