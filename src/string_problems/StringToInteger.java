package string_problems;

// 8. String to Integer (atoi)
public class StringToInteger {

    private static Integer toInteger(String s) {

        int i = 0;
        int length = s.length();
        int sign = 1;
        int result = 0;

        while (i < length && s.charAt(i) == ' ') {
            i++;
        }

        if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : +1 ;
        }

        while (i < length && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }

    public static void main(String[] args) {

        String s = " 43"; // " -042", "word874521"

        Integer ans = toInteger(s);
        System.out.println("ans: " + ans);
    }
}
