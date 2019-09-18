package se.ecutbildning.hala;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ecutbildning.hala.hangman.Hangman;

/**
 * Unit test for hangman.
 */
public class HangmanTest
{
    private static Hangman hangman ;


     @Before
    public void game(){
         hangman = new Hangman("hangman");


    }
    @Test
    public void test_correct_word()
    {
        String word = "hangman";
        char letter = 'n';
        Assert.assertTrue(hangman.checkGuess(word));
        Assert.assertTrue(hangman.guess(letter));
        Assert.assertEquals(true,hangman.winner());



    }
    @Test
    public void test_incorrect(){
        String word = "";
        char letter = 'l';
        int expected = 1;
        Assert.assertFalse(hangman.checkGuess(word));
        Assert.assertFalse(hangman.guess(letter));
        Assert.assertEquals(String.valueOf(letter), hangman.felGuess.toString());
        Assert.assertEquals(expected, hangman.getGuessAmount());


    }
    @Test
    public void correct_created( ){

        String letter = "H";
        String expected = "_______";
        Assert.assertEquals(expected,hangman.toString());
        Assert.assertTrue(hangman.checkGuess(letter));
        String expected1 = "h______";
        assertEquals(expected1,hangman.toString());
        Assert.assertEquals(false, hangman.winner());

    }
}
