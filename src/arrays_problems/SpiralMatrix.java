package arrays_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 54. Spiral Matrix
public class SpiralMatrix {

    /*
        {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }

        top, bottom, left, right
    */
    static List<Integer> spiralMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0, bottom = row - 1;
        int left = 0, right = col - 1;

        int dir = 0;
        // dir == 0; left to right
        // dir == 1; top to bottom
        // dir == 2; right to left
        // dir == 3; bottom to top


        List<Integer> result = new ArrayList<Integer>();

        while (top <= bottom && left <= right) {

            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    // constant: row(top)
                    result.add(matrix[top][i]);
                }
                top++;
            }

            if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    //constant: col(right)
                    result.add(matrix[i][right]);
                }
                right--;
            }

            if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    // constant: col(bottom)
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    // constant: col(left)
                    result.add(matrix[i][left]);
                }
                left++;
            }

            dir++;

            if (dir == 4)
                dir = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralMatrix(matrix));
    }
}
