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

    public String getNumber(int base, Scanner input) {
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
        int INTEGER_MAX = Integer.MAX_VALUE;
        char[] CHARCTERS = Base_to_Base.CHARCTERS;

        int base = Base_to_Base.getBase(input);
        int converted = 0;
        boolean foundChar = false;
        int value = 0;
        boolean foundAll = true;
        String number;
        String convertable;

        if (base == 0) {
            System.out.println("Write a number using the digits I, V, X, L, C, D, and M:");
            number = input.next();
            number = number.toUpperCase();
            number = Roman_Conversion.optimizeRoman(number);
            converted = Roman_Conversion.romanToDecimal(number);
        } else if (base == 1) {
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
                    if (maxDist <= ((int) Math.pow((double) base, (double) i) * value)) {
                        System.out.println("Larger than max integer value.");
                        foundAll = false;
                        break;
                    }
                    converted += ((int) Math.pow((double) base, (double) i) * value);
                }
            }

        } else {
            System.out.print("Write a number using the digits 0");
            for (int i = 1; i < base; i++) {
                System.out.print(", " + CHARCTERS[i]);
            }
            System.out.println(":");
            number = input.next();
            converted = 0;
            foundChar = false;
            value = 0;
            foundAll = true;
            number = number.toUpperCase();
            // conversion function
            for (int i = 0; i < number.length(); i++) {
                foundChar = false;
                for (int c = 0; c < base; c++) {
                    if (number.charAt(i) == CHARCTERS[c]) {
                        value = c;
                        foundChar = true;
                    }
                }
                if (!foundChar) {
                    System.out.println(
                            "The number " + number.charAt(i) + " at " + i + " not found in available digits");
                    foundAll = false;
                } else {
                    converted += ((int) Math.pow((double) base, (double) i) * value);
                }

            }
        }
        if (converted > Integer.MAX_VALUE) {
            System.out.println("This number is too large to convert");
        }
        if (foundAll && converted < Integer.MAX_VALUE) {
            System.out
                    .println(number + " in base " + base + " = " + converted + " in base 10 numbering.");
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
