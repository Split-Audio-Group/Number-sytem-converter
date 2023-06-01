package src;

/**
 * Write a description of class ReverseFullSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
//import java.lang.Math;

public class Ten_to_Base {
    // instance variables - replace the example below with your own
    public static void tenToBase() {
        Scanner input = new Scanner(System.in);
        int base = Base_to_Base.getBase(input);
        int converted = -1;
        String convertable;

        while (converted < 0 || converted > Integer.MAX_VALUE) {
            System.out.println("What integer do you want converted to base " + base + "?");
            converted = Base_to_Base.toIntegerCheck(input.next());
        }
        convertable = tenToBase(converted, base);

        System.out.print(convertable);
        input.close();
    }

    public static String tenToBase(int converted, int base) {
        String convertable;

        convertable = "";

        while (converted > 0) {
            int digit = converted % base; // rightmost digit
            convertable = Base_to_Base.CHARCTERS[digit] + convertable; // string concatenation
            converted = converted / base;
        }

        return convertable;
    }

    public static void main(String[] args) {
        tenToBase();
    }
}
