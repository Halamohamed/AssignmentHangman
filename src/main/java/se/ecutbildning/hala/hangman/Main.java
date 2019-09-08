package se.ecutbildning.hala.hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean keepAlive = false;
        System.out.println("Hangman game: ");
        System.out.println("Guess word :" );
        do {
            Hangman hangman = new Hangman();
            RunGame runGame = new RunGame(hangman);
            System.out.println(String.copyValueOf(runGame.getCopySecret()));
            runGame.spela();
            //System.out.println(hangman.getFelGuess());
            System.out.println("would you like to quite (y/n)");
            switch (Input.getchar()){
                case 'y':
                    keepAlive= false;
                    break;
                case 'n':
                    keepAlive= true;
                    break;
                default:
                    System.out.println("Bye!");
            }
        }while (keepAlive);

    }
}
