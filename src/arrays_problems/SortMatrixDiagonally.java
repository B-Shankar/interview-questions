package arrays_problems;

import java.util.*;

// 1329. Sort the Matrix Diagonally
public class SortMatrixDiagonally {

    /*
        Input: mat = [
            [3,3,1,1],
            [2,2,1,2],
            [1,1,1,2]
        ]
        Output: [
            [1,1,1,1],
            [1,2,2,2],
            [1,2,3,3]
        ]
    */

    static int[][] diagonalSort(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map.computeIfAbsent(i-j, k -> new ArrayList<>()).add(matrix[i][j]);
            }
        }

        for (List<Integer> group : map.values()) {
            Collections.sort(group);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

//                List<Integer> list = map.get(i-j);
//                matrix[i][j] = list.remove(0);

                matrix[i][j] = map.get(i-j).removeFirst();
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2}
        };

        System.out.println(Arrays.deepToString(diagonalSort(matrix)));
    }
}
