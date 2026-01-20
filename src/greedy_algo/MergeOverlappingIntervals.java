package greedy_algo;

import java.util.ArrayList;
import java.util.Arrays;

// Merge Overlapping Intervals
public class MergeOverlappingIntervals {

    private static ArrayList<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();

        // Checking for all possible overlaps
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            // Skipping already merged intervals
            if (!res.isEmpty() && res.get(res.size() - 1)[1] >= end) {
                continue;
            }

            // Find the end of the merged range
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                }
            }
            res.add(new int[]{start, end});
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        ArrayList<int[]> res = mergeOverlap(arr);

        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}

/*
Given an array of time intervals where arr[i] = [starti, endi], our task is to merge all the overlapping intervals into one and output the result which should have only mutually exclusive intervals.

Examples:

Input: arr[] = [[1, 3], [2, 4], [6, 8], [9, 10]]
Output: [[1, 4], [6, 8], [9, 10]]
Explanation: In the given intervals, we have only two overlapping intervals [1, 3] and [2, 4]. Therefore, we will merge these two and return [[1, 4]], [6, 8], [9, 10]].

Input: arr[] = [[7, 8], [1, 5], [2, 4], [4, 6]]
Output: [[1, 6], [7, 8]]
Explanation: We will merge the overlapping intervals [[1, 5], [2, 4], [4, 6]] into a single interval [1, 6].
 */