package greedy_algo;

import java.util.PriorityQueue;

// Activity Selection
public class ActivitySelection {

    static int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int ans = 0;

        // Min Heap to store activities in ascending order
        // of finish time
        PriorityQueue<int[]> p = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            p.add(new int[] { finish[i], start[i] });
        }

        // to store the end time of the last selected activity
        int finishtime = -1;

        while (!p.isEmpty()) {
            int[] activity
                    = p.poll();
            if (activity[1] > finishtime) {
                finishtime = activity[0];
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] finish = { 2, 4, 6, 7, 9, 9 };

        System.out.println(
                activitySelection(start, finish));
    }
}
/*
Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time, and an activity can be performed only if its start time is greater than the finish time of the last chosen activity.
Find the maximum number of activities that can be performed without overlapping.

Examples:

Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: A person can perform at most four activities. The maximum set of activities that can be performed is {0, 1, 3, 4} (these are the indexes in the start[] and finish[] arrays).

Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
Output: 1
Explanation: A person can perform at most one activity.
 */