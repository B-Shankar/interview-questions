package string_problems;

// 844. Backspace String Compare
public class BackspaceStringCompare {

    static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;

        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false;

            i--; j--;
        }

        return true;
    }

    public static void main(String[] args) {
//        String s = "ab#c", t = "ad#c";
//        String s = "ab##", t = "c#d#";
        String s = "a#c", t = "b";

        System.out.println(backspaceCompare(s, t));
    }
}
