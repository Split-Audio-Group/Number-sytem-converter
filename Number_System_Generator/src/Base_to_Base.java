package src;

/**
 * Write a description of class CompleteSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Base_to_Base {
    // instance variables - replace the example below with your own
    public static char[] CHARCTERS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
            'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '!',
            '@', '#', '$', '%', '^', '&', '*' };

    public static int toIntegerCheck(String testForType) {
        for (int i = 0; i < testForType.length(); i++) {
            if (!Character.isDigit(testForType.charAt(i))) {
                return -1;
            }
        }
        return Integer.parseInt(testForType);
    }

    public static int getBase(Scanner input) {
        // 0 will be roman numerals
        int base = -1;
        String testForType = "";

        while (base > CHARCTERS.length || base < 0) {
            System.out
                    .println("What do you want your base to be?(1-" + CHARCTERS.length + " or 0 for Roman Numberals)");
            testForType = input.next();
            base = toIntegerCheck(testForType);
            if (base < 0) {
                System.out.println("Please only use digits (0-9). Avoid letters and special characters.");
            }
        }
        return base;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int startBase = getBase(input);
            String number = "INVALID";
            while (number.equals("INVALID")) {
                number = Base_to_Ten.getNumber(startBase, input);
            }
            int startValue = Base_to_Ten.baseToTen(number, startBase);
            int endBase = getBase(input);
            String result = Ten_to_Base.tenToBase(startValue, endBase);
            if (endBase == 0) {
                System.out
                        .println(number + " in base " + startBase + " = " + result + " in Roman Numeral numbering.");
            } else {
                System.out
                        .println(number + " in base " + startBase + " = " + result + " in base " + endBase
                                + " numbering.");
            }
        }

    }
}
