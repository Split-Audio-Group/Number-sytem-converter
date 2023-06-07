package src;

import java.util.Scanner;

import java.lang.Math;

public class Base_to_Ten {

    public static int baseToTen() {
        Scanner input = new Scanner(System.in);
        int number = baseToTen(input);
        input.close();
        return number;
    }

    public static String getNumber(int base, Scanner input) {
        char[] CHARCTERS = Base_to_Base.CHARCTERS;
        char[] ROMAN_DICTIONARY = Roman_Conversion.ROMAN_DICTIONARY;
        String number = "";
        if (base == 0) {
            System.out.print("Write a number using the digits I");
            for (int i = 1; i < ROMAN_DICTIONARY.length; i++) {
                System.out.print(", " + ROMAN_DICTIONARY[i]);
            }
            System.out.println(":");
            number = input.next();
            number = number.toUpperCase();
            number = Roman_Conversion.optimizeRoman(number);
        } else if (base == 1) {
            System.out.println("Write a number using the digits 1:");
            number = input.next();
            number = number.toUpperCase();
            // conversion function
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) != '1') {
                    System.out.println("Char " + number.charAt(i) + " at " + i + " not found in vailable digits");
                    number = "INVALID";
                }
            }

        } else {
            System.out.print("Write a number using the digits 0");
            for (int i = 1; i < base; i++) {
                System.out.print(", " + CHARCTERS[i]);
            }
            System.out.println(":");
            number = input.next();
            Boolean foundAll = true;
            Boolean foundChar = false;
            number = number.toUpperCase();
            // conversion function
            for (int i = 0; i < number.length(); i++) {
                foundChar = false;
                for (int c = 0; c < base; c++) {
                    if (number.charAt(i) == CHARCTERS[c]) {
                        foundChar = true;
                    }
                }
                if (!foundChar) {
                    foundAll = false;
                }
            }
            if (!foundAll) {
                number = "INVALID";
            }
        }
        return number;
    }

    public static int baseToTen(Scanner input) {
        int base = Base_to_Base.getBase(input);
        String number = getNumber(base, input);
        return baseToTen(number, base);
    }

    public static int baseToTen(String number, int base) {
        int converted = 0;
        int value = 0;
        String convertable;

        if (base == 0) {
            number = Roman_Conversion.optimizeRoman(number);
            converted = Roman_Conversion.romanToDecimal(number);
        } else if (base == 1) {
            converted = 0;
            value = 1;
            convertable = number.toUpperCase();
            // conversion function
            for (int i = 0; i < convertable.length(); i++) {
                int maxDist = Integer.MAX_VALUE - converted;
                if (maxDist <= ((int) Math.pow((double) base, (double) i) * value)) {
                    converted = Integer.MAX_VALUE;
                    break;
                }
                converted += ((int) Math.pow((double) base, (double) i) * value);
            }

        } else {
            for (int i = 0; i < number.length(); i++) {
                int maxDist = Integer.MAX_VALUE - converted;
                if (maxDist <= ((int) Math.pow((double) base, (double) i) * value)) {
                    converted = Integer.MAX_VALUE;
                    break;
                }
                converted += ((int) Math.pow((double) base, (double) i) * value);
            }
        }
        if (converted > Integer.MAX_VALUE) {
            System.out.println("This number is too large to convert");
        }
        if (converted < Integer.MAX_VALUE) {
            return converted;
        } else {
            System.out.println("This number has error(s) listed above.");
            return -1;
        }
    }

    public static void main(String[] args) {
        baseToTen();
    }
}
