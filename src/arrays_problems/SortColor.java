package arrays_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortColor {
    /*
    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    */

    static int[] sortColor(int[] arr) {
        int n = arr.length;

        int i = 0;
        int j = 0;
        int k = n - 1;

        while (j <= k) {
            if (arr[j] == 1) {
                j++;
            } else if (arr[j] == 2) {
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                k--;
            } else {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(sortColor(arr)));
    }
}
