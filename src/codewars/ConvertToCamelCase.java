package codewars;//Complete the method/function so that it converts dash/underscore delimited words into camel casing.
// The first word within the output should be capitalized only if the original word was capitalized
// (known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.

import static java.lang.Math.min;

public class ConvertToCamelCase {
    public static void main(String[] args) {
        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(toCamelCase("The_Stealth_Warrior"));
        System.out.println(toCamelCase(""));
        System.out.println(toCamelCase("The_Stealth-Warrior"));
    }

    static String toCamelCase (String s) {
        String string = s;
        StringBuilder result = new StringBuilder();
        string = s;
        int min = findFirstOccurrence(string);
        if (min < 0) return s;
        while (min > 0) {
            String word = string.substring(0, min);
            if (!result.toString().isBlank()) {
                String letter = word.substring(0, 1);
                word = letter.toUpperCase() + word.substring(1);
            }
            result.append(word);
            string = string.substring(min + 1);
            min = findFirstOccurrence(string);
        }
        string = string.substring(0, 1).toUpperCase() + string.substring(1);
        result.append(string);
        return result.toString();
    }

    static int findFirstOccurrence (String str) {
        int dash = str.indexOf("-");
        int underscore = str.indexOf("_");
        return (dash > 0)&&(underscore > 0) ? min(dash, underscore) : dash > 0 ? dash : underscore;
    }
}
