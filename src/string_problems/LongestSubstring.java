package string_problems;

import java.util.HashMap;
import java.util.Map;

// 3. Longest Substring Without Repeating Characters [Medium]
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

    // Time Complexity: O(n); Space Complexity: O(n)
    public static int lengthOfLongestSubstringOptimised(String s) {
        int left = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) { // O(n)

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";

        int ans = lengthOfLongestSubstring(s);
        int ans1 = lengthOfLongestSubstringOptimised(s);
        System.out.println("ANS: " + ans);
        System.out.println("ANS: " + ans1);
    }
}
