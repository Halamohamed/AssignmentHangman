package se.ecutbildning.hala.hangman;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static char getchar(){
        boolean valid = false;
        char c = 0;
        if(!valid){
            try {
                c = getString().charAt(0);
                valid = true;

            }catch (NumberFormatException e){
                System.out.println("invalid format " + e.getMessage());
            }
        }return c;
    }
    public static String getString(){
        return scanner.nextLine();
    }

    public static int getInt(){
        int i = 0;
        i = scanner.nextInt();
        return i;
    }
}
