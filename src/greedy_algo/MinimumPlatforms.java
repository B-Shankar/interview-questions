package greedy_algo;

// Minimum Platform Required
public class MinimumPlatforms {

    private static int minimumPlatformRequired(int[] arr, int[] dep) {
        int res = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 0; j < n; j++) {

                if (i != j) {

                    if (arr[i] >= arr[j] && dep[j] >= arr[i]) {
                        count++;
                    }
                }
            }
            res = Math.max(count, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {900, 1235, 1100};
        int[] dep = {1000, 1240, 1200};

        int platform = minimumPlatformRequired(arr, dep);
        System.out.println("Minimum Platform: " + platform);
    }
}

/*
Given two arrays arr[] and dep[], that represent the arrival and departure time of i-th train respectively. Find the minimum number of platforms required so that no train has to wait. If the departure time of one train is the same as the arrival time of another train, both trains cannot use the same platform at that time.

Note: Time intervals are in the 24-hour format (HHMM), where the first two characters represent hour (between 00 to 23) and the last two characters represent minutes (this will be <= 59 and >= 0). Leading zeros for hours less than 10 are optional (e.g., 0900 is the same as 900).

nput: arr[] = [1000, 935, 1100], dep[] = [1200, 1240, 1130]
Output: 3
Explanation: We need 3 platforms for the arrival of these trains because all three trains have overlapping time.

409843035
Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
Output: 1
Explanation: Only 1 platform is required for all the three trains because the departure time of each train is less then arrival time of next train.
*/