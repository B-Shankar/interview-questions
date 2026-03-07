package arrays_problems;

// 835. Image Overlap

/*
    Row shifts = 2n-1
    Col shifts = 2n-1
    Matrix scan = n²

    Total: O((2n-1)² * n²)
            ≈ O(n⁴)
*/
public class ImageOverlap {

    // nxn
    static int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;

        int maxOverlap = 0;

        /*
            // rows(2x2): -1, 0, 1
            // cols(2x2): -1, 0, 1

            (-n+1) => (n-1)
        */
        for (int row_offset = -(n-1); row_offset < n; row_offset++) {
            for (int col_offset = -(n-1); col_offset < n; col_offset++) {

                int count = overlapCount(A, B, row_offset, col_offset);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }

        return maxOverlap;
    }

    static int overlapCount(int[][] A, int[][] B, int row_offset, int col_offset) {
        int n = A.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // A[i][j] => B[i+row_offset][j+col_offset]

                int b_row = i + row_offset;
                int b_col = j + col_offset;

                if (b_row < 0 || b_row >= n || b_col < 0 || b_col >= n)
                    continue;

                if (A[i][j] == 1 && B[b_row][b_row] == 1)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] img1 = {{1,1,0}, {0,1,0}, {0,1,0}};
        int[][] img2 = {{0,0,0}, {0,1,1}, {0,0,1}};

        System.out.println(largestOverlap(img1, img2));
    }
}
