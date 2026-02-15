package arrays_problems;

// 799. Champagne Tower
public class ChampagneTower {

    public static double champagneTower(int poured, int query_row, int query_glass) {

        double[] dp = new double[101];
        dp[0] = poured;

        for (int r = 0; r < query_row; r++) {
            double[] next = new double[101];

            for (int c = 0; c <= r; c++) {
                if (dp[c] > 1) {
                    double overflow = (dp[c] - 1) / 2.0;
                    next[c] += overflow;
                    next[c + 1] += overflow;
                }
            }
            dp = next;
        }

        return Math.min(1.0, dp[query_glass]);
    }

    public static void main(String[] args) {
        System.out.println(champagneTower(2, 1, 1));
    }
}
