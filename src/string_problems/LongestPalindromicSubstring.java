package string_problems;

// 5. Longest Palindromic Substring
public class LongestPalindromicSubstring {

    // Complexity: O(n)
    private static String longestPalindromeSubstring(String s) {

        int resLen = 0;
        String res = "";

        int left, right = 0;
        for (int i = 0; i < s.length(); i++) {

            // Odd Length Palindrome
            left = i; right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                left--;
                right++;
            }

            // Even Length Palindrome
            left = i; right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                left--;
                right++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "babad";

        String ans = longestPalindromeSubstring(s);
        System.out.println("ans: " + ans);
    }

    private static int palindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return 0;

            left++;
            right--;
        }

        return 1;
    }
}
