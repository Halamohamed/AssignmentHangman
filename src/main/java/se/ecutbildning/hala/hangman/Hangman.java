package se.ecutbildning.hala.hangman;

import java.util.Arrays;
import java.util.Random;

public class Hangman {
    private String secret;
    public char[] secretArray;
    private int guessAmount;
    public final int maxGuess = 8;
    public StringBuilder felGuess;

    public Hangman(String secret) {
        this.secret = secret;
        this.guessAmount = 0;
        this.secretArray = new char[secret.length()];
        this.felGuess = new StringBuilder();
        Arrays.fill(secretArray, '_');

    }

    public int getGuessAmount() {
        return guessAmount;
    }

    public boolean guess(String word){
        if(secret.equalsIgnoreCase(word)){
            secretArray = secret.toCharArray();
            return true;
        }
        guessAmount++;
        return false;
    }

    public boolean guess(char letter){
        if (secret.contains(String.valueOf(letter))){
            for (int i=0; i< secret.length(); i++){
                if(letter == secret.charAt(i)){
                    secretArray[i] = letter;
                    felGuess.append(letter);
                }
            }return true;
        }
        guessAmount++;
        felGuess.append(letter);
        return false;
    }

    public boolean checkGuess(String word){
        word = word.toLowerCase();
        if (word.length()> 1){
           return guess(word.toLowerCase());
        }
        if(!felGuess.toString().contains(word)){
            return guess(word.charAt(0));
        }
        return false;
    }
    public boolean winner(){
        boolean win = String.valueOf(secretArray).equals(secret);
        return win;
    }
    @Override
    public String toString(){
        return String.copyValueOf(secretArray);
    }


}
