
/**
 * Write a description of class FullSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

import java.lang.Math;

public class FullSystem {
    // instance variables - replace the example below with your own
    private static int exp(int base, int power) {
        if (power <= 0) {
            return 1;
        } else {
            int answer = base;
            for (int i = 0; i < power - 1; i++) {
                answer = answer * base;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int INTEGER_MAX = Integer.MAX_VALUE;
        char[] CHARCTERS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '!',
                '@', '#', '$', '%', '^', '&', '*' };
        int baseStart = 0;
        String testForType = "";
        boolean onlyNumbers = true;

        while (baseStart > CHARCTERS.length || baseStart < 1) {
            onlyNumbers = true;
            System.out.println("What do you want your starting base to be?(1-" + CHARCTERS.length + ")");
            testForType = input.next();

            for (int i = 0; i < testForType.length(); i++) {
                // System.out.println(testForType.charAt(i));
                if (!Character.isDigit(testForType.charAt(i))) {
                    onlyNumbers = false;
                }
            }
            if (!onlyNumbers) {
                System.out.println("Please only use digits (0-9). Avoid letters and special characters.");
            } else {
                int temp = 0;
                for (int i = testForType.length() - 1; i >= 0; i--) {
                    for (int j = 0; j < CHARCTERS.length; j++) {
                        if (CHARCTERS[j] == testForType.charAt(i)) {
                            temp += j * exp(10, (testForType.length() - (i + 1)));
                        }

                    }
                }
                baseStart = temp;
            }
        }
        int converted = 0;
        boolean foundChar = false;
        int value = 0;
        boolean foundAll = true;
        String number;
        String convertable;

        if (baseStart == 1) {
            System.out.println("Write a number using the digits 1:");
            number = input.next();
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
                    System.out.println("Char " + convertable.charAt(i) + " at " + i + " not found in vailable digits");
                    foundAll = false;
                } else {
                    int maxDist = INTEGER_MAX - converted;
                    if (maxDist <= ((int) Math.pow((double) baseStart, (double) i) * value)) {
                        System.out.println("Larger than max integer value.");
                        foundAll = false;
                        break;
                    }
                    converted += ((int) Math.pow((double) baseStart, (double) i) * value);
                }
            }

        } else {
            System.out.print("Write a number using the digits 0");
            for (int i = 1; i < baseStart; i++) {
                System.out.print(", " + CHARCTERS[i]);
            }
            System.out.println(":");
            number = input.next();
            converted = 0;
            foundChar = false;
            value = 0;
            foundAll = true;
            convertable = number.toUpperCase();
            // conversion function
            for (int i = 0; i < convertable.length(); i++) {
                foundChar = false;
                for (int c = 0; c < baseStart; c++) {
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
                    converted += ((int) Math.pow((double) baseStart, (double) i) * value);
                }

            }
        }
        if (converted > Integer.MAX_VALUE) {
            System.out.println("This number is too large to convert");
        }
        if (foundAll && converted < Integer.MAX_VALUE) {
            System.out
                    .println(convertable + " in base " + baseStart + " = " + converted + " in base 10 numbering.");

            int base = 0;
            while (base > CHARCTERS.length || base < 1) {
                onlyNumbers = true;
                System.out.println("What do you want your number to be turned to?(1-" + CHARCTERS.length + ")");
                testForType = input.next();

                for (int i = 0; i < testForType.length(); i++) {
                    // System.out.println(testForType.charAt(i));
                    if (!Character.isDigit(testForType.charAt(i))) {
                        onlyNumbers = false;
                    }
                }
                if (!onlyNumbers) {
                    System.out.println("Please only use digits (0-9). Avoid letters and special characters.");
                } else {
                    int temp = 0;
                    for (int i = testForType.length() - 1; i >= 0; i--) {
                        for (int j = 0; j < CHARCTERS.length; j++) {
                            if (CHARCTERS[j] == testForType.charAt(i)) {
                                temp += j * exp(10, (testForType.length() - (i + 1)));
                            }

                        }
                    }
                    base = temp;
                }
            }
            /*
             * int converted = 0;
             * boolean foundChar = false;
             * int value = 0;
             * boolean foundAll = true;
             * String convertable;
             */

            convertable = "";
            if (base == 1) {
                for (int i = 0; i < converted; i++) {
                    convertable = "1" + convertable;
                }
            } else {
                while (converted > 0) {
                    int digit = converted % base; // rightmost digit
                    convertable = CHARCTERS[digit] + convertable; // string concatenation
                    converted = converted / base;
                }

                System.out.println(
                        number + " in base " + baseStart + " = " + convertable + " in base " + base + " numbering.");
            }

        } else {
            System.out.println("This number has error(s) listed above.");
        }

        input.close();
    }
}
