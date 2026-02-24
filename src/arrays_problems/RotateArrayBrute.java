package arrays_problems;

import java.util.Arrays;
import java.util.Collections;

// Brute force
// Time & Space: O(n*n)
public class RotateArrayBrute {

    static void rotateArray(int[][] arr) {
        int n = arr.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                res[j][n - 1 - i] = arr[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = res[i][j];
            }
        }
    }

    // Rotate Array: 90 degree
    static void transposeAndReverse(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

//        rotateArray(arr);
        transposeAndReverse(arr);

        System.out.println(Arrays.deepToString(arr));
    }
}
