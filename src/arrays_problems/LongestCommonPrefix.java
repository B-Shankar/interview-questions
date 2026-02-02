package arrays_problems;

import java.util.Arrays;

// 14. Longest Common Prefix
public class LongestCommonPrefix {

    // Time Complexity: O(n log n · m)
    private static String longestCommonPrefix(String[] arr) {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(arr); // O(n log n · m)      n -> Strings; m -> Characters

        String s1 = arr[0];
        String s2 = arr[arr.length - 1];

        for (int i = 0; i < s1.length(); i++) { //  O(m)
            if (s1.charAt(i) == s2.charAt(i)) {
                ans.append(s1.charAt(i));
            } else {
                return ans.toString();
            }
        }

        return ans.toString();
    }


    /*
    We:
        Pick the first string as a reference

        Check its characters column by column

        For each character position i, we verify:
         => “Does every other string have the same character at this position?”

        The moment one string fails, we stop — that’s the end of the common prefix

        This is called vertical scanning.
    */
    // Time complexity: O(n · m)
    private static String longestCommonPrefixOptimised(String[] arr) {
        if (arr == null || arr.length == 0) return "";

        for (int i = 0; i < arr[0].length(); i++) {
            char c = arr[0].charAt(i);

            for (int j = 1; j < arr.length; j++) {

                // Case 1: string is too short
                // Case 2: character mismatch
                if (i >= arr[j].length() || arr[j].charAt(i) != c) {
                    return arr[0].substring(0, i);
                }
            }
        }

        return arr[0];
    }

    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};

        System.out.println("Longest Common Prefix: " + longestCommonPrefix(arr));
        System.out.println("Longest Common Prefix: " + longestCommonPrefixOptimised(arr));
    }
}
