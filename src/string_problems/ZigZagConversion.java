package string_problems;

// 6. Zigzag Conversion
public class ZigZagConversion {

    // Time Complexity: O(n), Space Complexity: O(n)
    public static String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int dir = 1; // 1 = down, -1 = up

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            if (row == 0) dir = 1;
            else if (row == numRows - 1) dir = -1;

            row += dir;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }

    // Time Complexity: O(n)
    private static String convertOptimised(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder ans = new StringBuilder();
        int cycle = (numRows - 1) * 2;

        for (int row = 0; row < numRows; row++) {

            for (int i = row; i < s.length(); i += cycle) {

                ans.append(s.charAt(i));

                int diag = i + cycle - 2 * row;
                if (row > 0 && row < numRows - 1 && diag < s.length()) {
                    ans.append(s.charAt(diag));
                }
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        String test1 = "PAYPALISHIRING"; // PAHNAPLSIIGYIR
        String test2 = "PAYPALISHIRING"; // PINALSIGYAHRPI

        System.out.println("Result: " + convert(test1, 3));
        System.out.println("Result: " + convertOptimised(test2, 4));
    }
}
