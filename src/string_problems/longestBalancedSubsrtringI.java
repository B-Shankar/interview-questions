package string_problems;

// 3713. Longest Balanced Substring I
public class longestBalancedSubsrtringI {
    public static int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';

                if (freq[idx] == 0) distinct++;

                freq[idx]++;
                maxFreq = Math.max(maxFreq, freq[idx]);

                int length = j - i + 1;

                // O(1) balance check
                if (length == distinct * maxFreq) {
                    maxLen = Math.max(maxLen, length);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));
    }
}
