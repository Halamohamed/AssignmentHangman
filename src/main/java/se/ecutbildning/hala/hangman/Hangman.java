package se.ecutbildning.hala.hangman;

import java.util.Random;

public class Hangman {
    private String secret;
    private char[] secretArray;
    private int guessAmount;
    private int maxGuess;
    private String felGuess;
    public static Random random = new Random();

    public Hangman() {
        this.secret = getWordToGuess();
        this.guessAmount = 1;
        this.maxGuess = 8;
        this.secretArray = secret.toCharArray();
        this.felGuess= "";

    }


    public String getFelGuess() {
        return felGuess;
    }

    public void setFelGuess(String felGuess) {
        this.felGuess += felGuess.toUpperCase() ;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public char[] getSecretArray() {
        return secretArray;
    }

    public void setSecretArray(char[] secretArray) {
        this.secretArray = secretArray;
    }

    public int getGuessAmount() {
        return guessAmount;
    }

    public void setGuessAmount(int guessAmount) {
        this.guessAmount = guessAmount;
    }

    public int getMaxGuess() {
        return maxGuess;
    }

    public  String getWordToGuess()
    {
        String HiddenWord = " ";

        for (int index = 1; index <= 5; index++){
            int word =  random.nextInt(5);

            switch(word)
            {
                case 1: HiddenWord = "elefant";
                    break;
                case 2: HiddenWord = "basket";
                    break;
                case 3: HiddenWord = "cykel";
                    break;
                case 4: HiddenWord = "program";
                    break;

            }
        }
        return HiddenWord;
    }


}
