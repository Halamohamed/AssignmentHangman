package se.ecutbildning.hala.hangman;


import java.util.Random;

public class Main {
    private static String[] secretList = {"program", "elefant","basket","cykel"};
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("");
        spelaGame();
            System.out.println("would you like to quite (y/n)");
            switch (Input.getchar()) {
                case 'n':
                    spelaGame();
                    break;
                default:
                    System.out.println("Bye!");
            }
        }

    public static void spelaGame(){
        System.out.println("Welcome to Hangman game: ");
        Hangman hangman = new Hangman("program");
        do {
            System.out.println("Guess word or letter" );
            //System.out.println(String.copyValueOf(hangman.secretArray));
            String word = Input.getString();
            hangman.checkGuess(word);
            // hangman.winner();
            //System.out.println("All guessing : " + hangman.felGuess);
            System.out.println(" fel guessed  :" + hangman.getGuessAmount() + " / " + hangman.maxGuess);
            System.out.println(" the secret word is: " + hangman);

        }while ( !hangman.winner() && hangman.getGuessAmount()<= hangman.maxGuess);

    }
}
