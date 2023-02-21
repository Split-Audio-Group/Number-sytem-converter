
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.lang.Math;

public class Main {
    // instance variables - replace the example below with your own
    public static String duplicate(String str) {
        String finalWord = "";
        if (str.length() % 2 == 0) {
            for (int i = 0; i < str.length(); i++) {
                for (int c = 0; c < str.length() * 2; c++) {
                    finalWord += str.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                for (int c = 0; c < str.length(); c++) {
                    finalWord += str.charAt(i);
                }
            }
        }
        return finalWord;
    }

    public static boolean isEdhesivePalindrome(String str) {
        boolean pal = true;
        str = str.toUpperCase();
        str.replace("4", "A");
        str.replace("3", "E");
        str.replace("0", "O");
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                pal = false;
            }
        }
        return pal;
    }

    public static double numberScramble(double num) {
        num += 5;
        num /= 2;
        num = Math.sqrt(num);
        return num;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Methods Sampler Platter. Please enter a String to duplicate.");
        String doubling = input.next();
        System.out.println("The duplicated String is: " + duplicate(doubling));
        System.out.println("Next, please enter a String to check for Edhesive Palindromes.");
        String pal = input.next();
        if (isEdhesivePalindrome(pal)) {
            System.out.println("Nice, you found an Edhesive Palindrome!");
        } else {
            System.out.println("Too bad, that isn't an Edhesive Palindrome.");
        }
        System.out.println("Almost done! Please enter a number to scramble.");
        double num = input.nextDouble();
        System.out.println("The scrambled number is: " + numberScramble(num));
        input.close();
    }
}
