package string_problems;

// 13. Roman to Integer
public class RomanToInteger {

    private static int toInteger(String s) {
        int ans = 0;
        int curr = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            curr = getValue(s.charAt(i));

            if (curr < prev) {
                ans -= curr;
            } else {
                ans += curr;
            }

            prev = curr;
        }

        return ans;
    }

    private static int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default  -> 0;
        };
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println("Integer: " + toInteger(s));
    }
}
