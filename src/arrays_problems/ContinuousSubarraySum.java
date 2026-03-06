package arrays_problems;

import java.util.HashMap;
import java.util.Map;

// 523. Continuous Subarray Sum
public class ContinuousSubarraySum {

    static boolean continuousSubarraySum(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            int reminder = sum % k;

            if (map.containsKey(reminder)) {
                if (i - map.get(reminder) >= 2)
                    return true;
            } else {
                map.put(reminder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {23, 2, 4, 6, 7};

        System.out.println(continuousSubarraySum(arr, 6));
    }
}
