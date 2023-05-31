package src;

/**
 * Write a description of class TestingCharacters here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// import java.util.Scanner;
// import java.lang.Math;
public class TestingCharacters {
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
        char[] CHARCTERS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        for (int i = 0; i < CHARCTERS.length; i++) {
            System.out.println((int) CHARCTERS[i] + " is converted from " + CHARCTERS[i]);
        }

    }
}
