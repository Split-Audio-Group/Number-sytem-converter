package src;

import java.util.Scanner;

public class Ten_to_Base {
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
        String convertable = "";

        if (base == 0) {

            String largest_roman = "";
            for (int i = Roman_Conversion.ROMAN_DICTIONARY.length - 1; i >= 0; i--) {
                largest_roman = largest_roman + Roman_Conversion.ROMAN_DICTIONARY[i]
                        + Roman_Conversion.ROMAN_DICTIONARY[i] + Roman_Conversion.ROMAN_DICTIONARY[i];
            }
            int roman_max = Roman_Conversion.romanToDecimal(largest_roman);

            if (converted > roman_max) {
                System.out.println("Number is larger than largest Roman Number");
                return "INVALID";
            }
            convertable = Roman_Conversion.decimalToRoman(converted);
            // System.out.println("Result: " + convertable);
        } else {
            // System.out.println("convert to base");
            convertable = "";
            while (converted > 0) {
                int digit = converted % base; // rightmost digit
                convertable = Base_to_Base.CHARCTERS[digit] + convertable; // string concatenation
                converted = converted / base;
            }
        }

        return convertable;
    }

    public static void main(String[] args) {
        tenToBase();
    }
}
