package leetcode;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        String longestSubstring = "";
        String currentSubstring = "";

        for (char letter : str) {
            if (currentSubstring.indexOf(letter) == -1) {
                currentSubstring += letter;
            } else {
                if (longestSubstring.length() < currentSubstring.length()) {
                    longestSubstring = currentSubstring;
                }
                currentSubstring = currentSubstring.substring(currentSubstring.indexOf(letter) + 1) + String.valueOf(letter);
            }
        }

        if (longestSubstring.length() < currentSubstring.length()) {
            longestSubstring = currentSubstring;
        }

        return longestSubstring.length();
    }
}