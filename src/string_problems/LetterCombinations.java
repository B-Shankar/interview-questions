package string_problems;

import java.util.*;

// 17. Letter Combinations of a Phone Number
public class LetterCombinations {

    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    private static List<String> result;

    public static List<String> letterCombinations(String digits) {

        result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        solve(0, digits, "");
        return result;
    }

    private static void solve(int index, String digits, String curr) {

        if (index == digits.length()) {
            result.add(curr);
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            solve(index + 1, digits, curr + c);
        }
    }

    public static void main(String[] args) {
        System.out.println("Combination: " + letterCombinations("23"));
    }
}
