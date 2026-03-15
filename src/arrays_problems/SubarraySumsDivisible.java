package arrays_problems;

import java.util.HashMap;
import java.util.Map;

// Subarray Sums Divisible by K
public class SubarraySumsDivisible {

    static public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            int remainder = prefixSum % k;

            if (remainder < 0) {
                remainder += k;
            }

            count += map.getOrDefault(remainder, 0);

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,0,-2,-3,1};
        int k = 5;

        System.out.println(subarraysDivByK(arr, k));
    }
}
