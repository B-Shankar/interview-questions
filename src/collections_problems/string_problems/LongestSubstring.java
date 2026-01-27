package collections_problems.string_problems;

import java.util.HashMap;
import java.util.Map;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstring {

    // O(n^2)
    public static int lengthOfLongestSubstring(String s) {
        StringBuilder x = new StringBuilder();
        int max = 0;

        for (char c : s.toCharArray()) {
            System.out.println("x: " + x);
            int idx = x.indexOf(String.valueOf(c)); // O(n) to scan

            System.out.println("idx: " + idx);

            if (idx != -1) {
                x.delete(0, idx + 1); // O(n) to delete
            }

            System.out.println("X: " + x);

            x.append(c);

            System.out.println("x: " + x);
            max = Math.max(max, x.length());
        }

        //Time Complexity: O(n * n) = O(n^2)

        return max;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";

        int ans = lengthOfLongestSubstring(s);
        System.out.println("ANS: " + ans);
    }
}
