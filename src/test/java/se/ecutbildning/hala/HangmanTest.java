package se.ecutbildning.hala;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutbildning.hala.hangman.Hangman;
import se.ecutbildning.hala.hangman.RunGame;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class HangmanTest
{
    /**
     * Hangman Test :-)
     */
    private static Hangman hangman = new Hangman();
    private static RunGame runGame = new RunGame(hangman);
    String secret;
    String copySecret;
    boolean winner;
    int amount = 0;
    int max = 8;
    String guess;
    static Random random = new Random();
    char[] word = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    @Before
    public void game(){
         secret = hangman.getSecret().toString();
         copySecret = hangman.getWordToGuess();

        while (!winner & amount<=max){
            amount++;
            for (int i= 0; i<word.length; i++)
                guess = String.valueOf(random.nextInt(26)) ;
            if(guess.length()>1)
                winner=runGame.printGuess(secret,guess);
            winner = runGame.guess(guess);
        }
    }
    @Test
    public void test_secret_with_getWordToGuess()
    {
        Assert.assertEquals(secret,hangman.getSecret());

    }
    @Test
    public void test_spela(){

        Assert.assertTrue(secret, runGame.printGuess(secret, guess));
        Assert.assertNotEquals(guess, runGame.guess(guess));


    }
}
