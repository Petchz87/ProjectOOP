package Game_puzzle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class modeGamePlay {
    //Easy
    protected Icon[] imgAligator = new Icon[4];
    protected Icon[] imgBird = new Icon[4];
    protected Icon[] imgCat = new Icon[4];
    protected Icon[] imgChicken = new Icon[4];
    protected Icon[] imgDinosaur = new Icon[4];
    protected Icon[] imgDog = new Icon[4];
    protected Icon[] imgDuck = new Icon[4];
    protected Icon[] imgFox = new Icon[4];
    protected Icon[] imgPig = new Icon[4];
    protected Icon[] imgSnake = new Icon[4];
    protected Icon[] imgWolf = new Icon[4];
    //Normal
    protected Icon[] imgBear = new Icon[9];
    protected Icon[] imgDuck2 = new Icon[9];
    protected Icon[] imgElephant = new Icon[9];
    protected Icon[] imgFish = new Icon[9];
    protected Icon[] imgHorse = new Icon[9];
    protected Icon[] imgJellyFish = new Icon[9];
    protected Icon[] imgMonkey = new Icon[9];
    protected Icon[] imgPig2 = new Icon[9];
    protected Icon[] imgPandaPo = new Icon[9];
    protected Icon[] imgPolar = new Icon[9];
    protected Icon[] imgSheep = new Icon[9];
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
    protected int tables;

    public void imageEasy(){
        tables = 4;
        for (int i = 0; i < tables; i++) {
            imgAligator[i] = new ImageIcon("Game_puzzle/picture/Easy/Aligator/" + (Math.abs(i-tables)) + ".jpg");
            imgBird[i] = new ImageIcon("Game_puzzle/picture/Easy/Bird/" + (Math.abs(i-tables)) + ".jpg");
            imgCat[i] = new ImageIcon("Game_puzzle/picture/Easy/Cat/" + (Math.abs(i-tables)) + ".jpg");
            imgChicken[i] = new ImageIcon("Game_puzzle/picture/Easy/Chicken/" + (Math.abs(i-tables)) + ".jpg");
            imgDinosaur[i] = new ImageIcon("Game_puzzle/picture/Easy/Dino/" + (Math.abs(i-tables)) + ".jpg");
            imgDog[i] = new ImageIcon("Game_puzzle/picture/Easy/Dog/" + (Math.abs(i-tables)) + ".jpg");
            imgDuck[i] = new ImageIcon("Game_puzzle/picture/Easy/Duck/" + (Math.abs(i-tables)) + ".jpg");
            imgFox[i] = new ImageIcon("Game_puzzle/picture/Easy/Fox/" + (Math.abs(i-tables)) + ".jpg");
            imgPig[i] = new ImageIcon("Game_puzzle/picture/Easy/Pig/" + (Math.abs(i-tables)) + ".jpg");
            imgSnake[i] = new ImageIcon("Game_puzzle/picture/Easy/Snake/" + (Math.abs(i-tables)) + ".jpg");
            imgWolf[i] = new ImageIcon("Game_puzzle/picture/Easy/Wolf/" + (Math.abs(i-tables)) + ".jpg");
        }
    }

     public void imageNormal(){
        tables = 9;
        for (int i = 0; i < tables; i++) {
            imgBear[i] = new ImageIcon("Game_puzzle/picture/Normal/Bear/" + (Math.abs(i-tables)) + ".jpg");
            imgDuck2[i] = new ImageIcon("Game_puzzle/picture/Normal/Duck2/" + (Math.abs(i-tables)) + ".jpg");
            imgElephant[i] = new ImageIcon("Game_puzzle/picture/Normal/Elephant/" + (Math.abs(i-tables)) + ".jpg");
            imgFish[i] = new ImageIcon("Game_puzzle/picture/Normal/Fish/" + (Math.abs(i-tables)) + ".jpg");
            imgHorse[i] = new ImageIcon("Game_puzzle/picture/Normal/Horse/" + (Math.abs(i-tables)) + ".jpg");
            imgJellyFish[i] = new ImageIcon("Game_puzzle/picture/Normal/Jellyfish/" + (Math.abs(i-tables)) + ".jpg");
            imgMonkey[i] = new ImageIcon("Game_puzzle/picture/Normal/Monkey/" + (Math.abs(i-tables)) + ".jpg");
            imgPig2[i] = new ImageIcon("Game_puzzle/picture/Normal/Pig2/" + (Math.abs(i-tables)) + ".jpg");
            imgPandaPo[i] = new ImageIcon("Game_puzzle/picture/Normal/PandaPo/" + (Math.abs(i-tables)) + ".jpg");
            imgPolar[i] = new ImageIcon("Game_puzzle/picture/Normal/Polar/" + (Math.abs(i-tables)) + ".jpg");
            imgSheep[i] = new ImageIcon("Game_puzzle/picture/Normal/Sheep/" + (Math.abs(i-tables)) + ".jpg");
        }
    }

    public void imageHard(){
        tables = 9;
        for (int i = 0; i < tables; i++) {
            imgCamel[i] = new ImageIcon("Game_puzzle/picture/Hard/Camel/" + (Math.abs(i-tables)) + ".jpg");
            imgCat2[i] = new ImageIcon("Game_puzzle/picture/Hard/Cat2/" + (Math.abs(i-tables)) + ".jpg");
            imgClam[i] = new ImageIcon("Game_puzzle/picture/Hard/Clam/" + (Math.abs(i-tables)) + ".jpg");
            imgCow[i] = new ImageIcon("Game_puzzle/picture/Hard/Cow/" + (Math.abs(i-tables)) + ".jpg");
            imgDoge[i] = new ImageIcon("Game_puzzle/picture/Hard/Doge/" + (Math.abs(i-tables)) + ".jpg");
            imgDophin[i] = new ImageIcon("Game_puzzle/picture/Hard/Dophin/" + (Math.abs(i-tables)) + ".jpg");
            imgOrca[i] = new ImageIcon("Game_puzzle/picture/Hard/Orca/" + (Math.abs(i-tables)) + ".jpg");
            imgOurTeacher[i] = new ImageIcon("Game_puzzle/picture/Hard/Our Teacher/" + (Math.abs(i-tables)) + ".jpg");
            imgPenguin1[i] = new ImageIcon("Game_puzzle/picture/Hard/Penguin1/" + (Math.abs(i-tables)) + ".jpg");
            imgPenguin2[i] = new ImageIcon("Game_puzzle/picture/Hard/Penguin2/" + (Math.abs(i-tables)) + ".jpg");
            imgTiger[i] = new ImageIcon("Game_puzzle/picture/Hard/Tiger/" + (Math.abs(i-tables)) + ".jpg");
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

        return answer = "BEAR";
    }

    public String answerOfHard() {
        String[] puzzle = { "ALIGATOR", "BIRD", "CAT", "CHICKEN", "DINOSAUR", "DOG", "DUCK", "FOX", "PIG", "SNAKE", "WOLF"};
        int rd = (int) (Math.random() * 10);
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
