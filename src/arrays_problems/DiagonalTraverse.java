package arrays_problems;

import java.util.*;

// 498. Diagonal Traverse
public class DiagonalTraverse {

    static int[] diagonalTraverse(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        //1. store in map
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map.computeIfAbsent(i+j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        //2. reverse alternate
        int reverse = 0;
        for (int d = 0; d <= row + col - 2; d++) {
            if (reverse % 2 == 0)
                Collections.reverse(map.get(d));

            reverse++;
        }

        //3. add and return
        int idx = 0;
        int[] result = new int[row * col];
        for (int i = 0; i <= row + col - 2; i++) {
            for (int value : map.get(i)) {
                result[idx++] = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.toString(diagonalTraverse(arr)));
    }
}
