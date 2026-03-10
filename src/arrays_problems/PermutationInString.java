package arrays_problems;

// 567. Permutation in String
public class PermutationInString {
    static public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            window[s2.charAt(right) - 'a']++;

            if (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            if (matches(s1Count, window)) return true;
        }

        return false;
    }

    static private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}
