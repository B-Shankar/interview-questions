package greedy_algo;

import java.util.ArrayList;

// Job Sequencing Problem
public class JobSequencing {

    static ArrayList<Integer> jobSchedulingWithMaxProfit(int[] deadline, int[] profit) {

        int n = deadline.length;
        int count = 0;
        int totalProfit = 0;

        ArrayList<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
        }

        jobs.sort((a, b) -> Integer.compare(b[0], a[0]));

        int[] slot = new int[n];

        for (int i = 0; i < n; i++) {
            int start = Math.min(n, jobs.get(i)[1]) -1;

            for (int j = start; j >= 0; j--) {

                if (slot[j] == 0) {
                    slot[j] = 1;
                    count++;
                    totalProfit += jobs.get(i)[0];
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(totalProfit);
        return result;
    }

    public static void main(String[] args) {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};

        ArrayList<Integer> result = jobSchedulingWithMaxProfit(deadline, profit);
        System.out.println("Jobs Completed: " + result.get(0) + ", Max Profit: " + result.get(1));
    }

}

/*
Given two arrays, deadline[] and profit[], where deadline[i] is the last time unit by which the i-th job must be completed, and profit[i] is the profit earned from completing it.
Each job takes 1 unit time, and only one job can be scheduled at a time. A job earns profit only if finished within its deadline. Find the number of jobs completed and maximum profit.

Examples:

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job 1 (profit 20, deadline 4) can be scheduled. Among the three jobs with deadline 1, only one fits, so we pick the highest profit (40). Hence, 2 jobs with total profit = 60.

Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Picking the job with profit 100 (deadline 2) and the job with profit 27 (deadline 2); they can occupy the two available slots before deadline 2. Thus 2 jobs are scheduled for a maximum total profit of 127.
 */