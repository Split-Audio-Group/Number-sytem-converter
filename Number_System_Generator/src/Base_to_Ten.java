package src;

import java.util.Scanner;

import java.lang.Math;

public class Base_to_Ten {

    public static int baseToTen() {
        Scanner input = new Scanner(System.in);
        int INTEGER_MAX = Integer.MAX_VALUE;
        char[] CHARCTERS = Base_to_Base.CHARCTERS;

        int base = Base_to_Base.getBase(input);
        int converted = 0;
        boolean foundChar = false;
        int value = 0;
        boolean foundAll = true;
        String number;
        String convertable;

        if (base == 1) {
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
                    converted += ((int) Math.pow((double) base, (double) i) * value);
                }

            }
        }
        if (converted > Integer.MAX_VALUE) {
            System.out.println("This number is too large to convert");
        }
        if (foundAll && converted < Integer.MAX_VALUE) {
            System.out
                    .println(convertable + " in base " + base + " = " + converted + " in base 10 numbering.");
            input.close();
            return converted;
        } else {
            System.out.println("This number has error(s) listed above.");
            input.close();
            return -1;
        }
    }

    public static void main(String[] args) {
        baseToTen();
    }
}
