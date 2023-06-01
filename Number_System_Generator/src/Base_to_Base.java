package src;

/**
 * Write a description of class CompleteSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.lang.Math;

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
        int base = 0;
        String testForType = "";

        while (base > CHARCTERS.length || base < 1) {
            System.out.println("What do you want your base to be?(1-" + CHARCTERS.length + ")");
            testForType = input.next();
            base = Base_to_Base.toIntegerCheck(testForType);
            if (base < 0) {
                System.out.println("Please only use digits (0-9). Avoid letters and special characters.");
            }
        }
        return base;
    }

    public static void main(String[] args) {
        int INTEGER_MAX = Integer.MAX_VALUE;
        try (Scanner input = new Scanner(System.in)) {
            int base = getBase(input);
            int converted = 0;
            boolean foundChar = false;
            int value = 0;
            boolean foundAll = true;
            String convertable;

            if (base == 1) {
                System.out.println("Write a number using the digits 1:");
                String number = input.next();
                converted = 0;
                foundChar = false;
                value = 1;
                foundAll = true;
                convertable = number.toUpperCase();
                // conversion function
                for (int i = 0; i < convertable.length(); i++) {
                    if (convertable.charAt(i) == '1') {
                        foundChar = true;
                    }
                    if (!foundChar) {
                        System.out.println(
                                "Char " + convertable.charAt(i) + " at " + i + " not found in vailable digits");
                        foundAll = false;

                    } else {
                        converted += ((int) Math.pow((double) base, (double) i) * value);
                    }
                }

            } else {
                System.out.print("Write a number using the digits 0");
                for (int i = 1; i < base; i++) {
                    System.out.print(", " + CHARCTERS[i]);
                }
                System.out.println(":");
                String number = input.next();
                converted = 0;
                foundChar = false;
                value = 0;
                foundAll = true;
                convertable = number.toUpperCase();
                // conversion function
                for (int i = 0; i < convertable.length(); i++) {
                    foundChar = false;
                    for (int c = 0; c < base; c++) {
                        if (convertable.charAt(i) == CHARCTERS[c]) {
                            value = c;
                            foundChar = true;
                        }
                    }
                    if (!foundChar) {
                        System.out.println(
                                "The number " + convertable.charAt(i) + " at " + i + " not found in available digits");
                        foundAll = false;
                    } else {
                        int maxDist = INTEGER_MAX - converted;
                        if (maxDist <= ((int) Math.pow((double) base, (double) i) * value)) {
                            System.out.println("Larger than max integer value.");
                            foundAll = false;
                            break;
                        }
                        converted += ((int) Math.pow((double) base, (double) i) * value);
                    }

                }
            }
            if (foundAll) {
                System.out.println(convertable + " in base " + base + " = " + converted + " in base 10 numbering.");
            } else {
                System.out.println("Incomplete calculation for reasons stated above.");
            }
        }

    }
}
