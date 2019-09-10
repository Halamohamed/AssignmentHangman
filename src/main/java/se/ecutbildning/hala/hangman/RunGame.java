package se.ecutbildning.hala.hangman;

import java.util.Arrays;

public class RunGame {
    private Hangman game;
    private boolean winner=false;
    private int no;
    private char[] copySecret;
    public RunGame(Hangman game){
        this.game = game;
        this.copySecret = new char[game.getSecretArray().length];
        Arrays.fill(copySecret,'_');
        no=1;
    }

    public char[] getCopySecret() {
        return copySecret;
    }

    public void setCopySecret(char copySecret,int i) {
        String cs = String.valueOf(copySecret).toUpperCase();
        this.copySecret[i] = cs.charAt(0);
    }

    public void spela() {

        while (!winner && game.getGuessAmount()<= game.getMaxGuess()){
            System.out.println("Guess :" + game.getGuessAmount() + " / " + game.getMaxGuess());
            System.out.println("Guess a char : ");
            String word = Input.getString();
            if(word.length()>1) {
                winner = printGuess(game.getSecret(), word);
                }else {
                winner = guess(word);
                if(getCopySecret().toString().equalsIgnoreCase(game.getSecret()))
                    System.out.println("winner!");
            }
            //System.out.println(" game over!");

            }

        //System.out.println(game.getFelGuess());

        }


    public boolean guess(String word) {
        no++;
        game.setGuessAmount(no);
            for (int i = 0; i < game.getSecretArray().length; i++) {
                if (String.valueOf(game.getSecretArray()[i]).equalsIgnoreCase(word)) {
                    if(getCopySecret()[i]== '_') {
                        setCopySecret(word.charAt(0), i); }
                    else {
                        System.out.println(" the char is already in the word");
                        no--;
                        game.setGuessAmount(no); }
                    if( word.charAt(0)!= getCopySecret()[i])
                    game.setFelGuess(word);
                }
            }
        if (game.getSecretArray().toString().equals(getCopySecret()))
            return true;
        System.out.println( getCopySecret());
        return false;
        }

    public boolean printGuess(String str, String input)
    {
        char [] Word = new char[str.length()];
        System.out.println("your input " + input);
        for (int i = 0; i < str.length(); i ++) {
            for (int j = 0; i < input.length(); j++) {
                if(input.charAt(i) == str.charAt(j))
                {
                    Word[j] = str.charAt(i);
                }
                else if (i == 0) {
                    Word[i] = '_'; }
                System.out.println("winner!");
                return true;
            }
        }
        System.out.println("you lose!");
        return false;

    }





    }





