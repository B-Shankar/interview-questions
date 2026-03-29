package string_problems;

import java.util.Arrays;

// 344. Reverse String
public class ReverseString {

    static public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h','e','l','l','o'};

        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
