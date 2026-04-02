package arrays_problems;

import java.util.ArrayList;
import java.util.List;

// 448. Find All Numbers Disappeared in an Array
// swap sort
public class FindAllNumbersDisappeared {

    /*
        1. swap if not correct; until it get corrected
    */

    static List<Integer> findDisappearedNumbers(int[] arr) {
        int n = arr.length;

        List<Integer> list = new ArrayList<>();

        int start = 0;

        while (start < n) {

            if (arr[start] != arr[arr[start] - 1]) {
                swap(arr, start, arr[start] - 1);
            } else {
                start++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(arr));
    }
}
