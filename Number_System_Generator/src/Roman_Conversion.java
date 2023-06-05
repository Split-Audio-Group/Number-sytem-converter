package src;

import java.util.Arrays;

public class Roman_Conversion {
    public static char[] ROMAN_DICTIONARY = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
    private static int[] ROMAN_VALUE = { 1, 5, 10, 50, 100, 500, 1000 };

    public static int romanToDecimal(String number) {
        int currentRoman = 0;
        int returnNumber = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            for (int j = 0; j < ROMAN_DICTIONARY.length; j++) {
                if (number.charAt(i) == ROMAN_DICTIONARY[j]) {
                    if (j > currentRoman) {
                        currentRoman = j;
                        returnNumber += ROMAN_VALUE[j];
                        break;
                    } else if (j < currentRoman) {
                        returnNumber -= ROMAN_VALUE[j];
                        break;
                    } else {
                        returnNumber += ROMAN_VALUE[j];
                        break;
                    }
                }
            }
        }
        return returnNumber;
    }

    public static String decimalToRoman(int number) {
        String returnString = "";
        boolean check = false;
        for (int i = ROMAN_VALUE.length - 1; i >= 0; i--) {
            boolean cut = false;
            for (int j = i; j >= 0; j--) {
                // System.out.println("I: " + ROMAN_VALUE[i] + "; J: " + ROMAN_VALUE[j]);

                if (i > 0 && (number / ROMAN_VALUE[j] > 2)
                        && (number / ROMAN_VALUE[j] < (ROMAN_VALUE[i] / ROMAN_VALUE[j]))) {
                    // System.out.println("Number: " + number + "; Remainder: " + (number %
                    // ROMAN_VALUE[i]) + "; Roman values: " + ROMAN_VALUE[i] + ", " +
                    // ROMAN_VALUE[j]);

                    if (number - (ROMAN_VALUE[i] - ROMAN_VALUE[j]) >= 0) {
                        returnString = returnString + ROMAN_DICTIONARY[j] + ROMAN_DICTIONARY[i];
                        // System.out.println("Return Update: " + returnString);
                        number -= (ROMAN_VALUE[i] - ROMAN_VALUE[j]);
                        // System.out.println("Number Update: " + number);
                    }

                    cut = true;
                }
                check = false;
            }
            if (!cut) {
                for (int j = 0; j < number / ROMAN_VALUE[i]; j++) {
                    returnString = returnString + ROMAN_DICTIONARY[i];
                    // System.out.println("Return Update: " + returnString);
                }
                // System.out.println("Roman: " + ROMAN_VALUE[i]);
                number = number % ROMAN_VALUE[i];
                // System.out.println("Number Update: " + number);
                // System.out.println("Check: " + check);
                if (!check && i > 1 && number > ROMAN_VALUE[i - 1]) {
                    check = true;
                }
            }
            if (check) {
                // System.out.println("*Checking*");
                i++;
                check = false;
            }
            // System.out.println("Minus i");
            if (number == 0) {
                break;
            }
            // System.out.println("Number: " + number);
            // System.out.println("Return: " + returnString);
        }
        return returnString;
    }

    public static String optimizeRoman(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Arrays.asList(ROMAN_DICTIONARY).contains(number.charAt(i))) {
                return "INVALID";
            }
        }
        return decimalToRoman(romanToDecimal(number));
    }

    public static boolean validRoman(String number) {
        return (romanToDecimal(number) > 0 && romanToDecimal(number) < 3999);
    }

    private static String generateBadRoman(int length) {
        String returnString = "";
        boolean valid = false;
        while (!valid) {
            returnString = "";
            for (int i = 0; i < length; i++) {
                returnString = returnString + ROMAN_DICTIONARY[(int) (Math.random() * ROMAN_DICTIONARY.length)];
            }
            valid = validRoman(returnString);
        }
        return returnString;
    }

    public static void main(String[] args) {
        /*
         * System.out.println(romanToDecimal("XIX"));
         * System.out.println(romanToDecimal("CXCII"));
         * System.out.println(romanToDecimal("CXCIX"));
         * System.out.println(romanToDecimal("MCXLVIII"));
         * System.out.println(romanToDecimal("CMLXXXIII"));
         * System.out.println(romanToDecimal("I"));
         * System.out.println(romanToDecimal("V"));
         * System.out.println(romanToDecimal("XXIII"));
         * System.out.println(romanToDecimal("MMXXIII"));
         * System.out.println(romanToDecimal("MCMXCII"));
         * System.out.println(romanToDecimal("CMXXVII"));
         * 
         * System.out.println(decimalToRoman(19));
         * System.out.println(decimalToRoman(192));
         * System.out.println(decimalToRoman(199));
         * System.out.println(decimalToRoman(1148));
         * System.out.println(decimalToRoman(983));
         * System.out.println(decimalToRoman(1));
         * System.out.println(decimalToRoman(5));
         * System.out.println(decimalToRoman(23));
         * System.out.println(decimalToRoman(2023));
         * System.out.println(decimalToRoman(1992));
         * System.out.println(decimalToRoman(927));
         */

        for (int i = 1; i <= 200; i++) {
            String test = "";
            System.out.println("Random Roman " + i + ":");
            test = generateBadRoman(20);
            System.out.println("\tGenerated Roman Numeral: " + test + " = " + romanToDecimal(test));
            test = optimizeRoman(test);
            System.out.println("\tOptimized Roman Numeral: " + test + " = " + romanToDecimal(test));
        }
    }

    /**
     * temp(){
     * if (i > 0 && (number % ROMAN_VALUE[i] > ROMAN_VALUE[i - 1] * 3)) {
     * System.out
     * .println("Number: " + number + "; Remainder: " + (number % ROMAN_VALUE[i]) +
     * "; Roman values: "
     * + ROMAN_VALUE[i] + ", " + ROMAN_VALUE[i - 1]);
     * returnString = returnString + ROMAN_DICTIONARY[i - 1] + ROMAN_DICTIONARY[i];
     * System.out.println("Return Update: " + returnString);
     * number -= (ROMAN_VALUE[i] - ROMAN_VALUE[i - 1]);
     * System.out.println("Number Update: " + number);
     * 
     * }
     * }
     **/
}
