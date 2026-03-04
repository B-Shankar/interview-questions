package arrays_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 219. Contains Duplicate II
public class ContainsDuplicateII {

    // Time & Space Complexity: O(n)
    static boolean containsDuplicateII(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }

    // Sliding Window
    // Time complexity: O(n), Space complexity: O(k)
    static boolean containsDuplicateIIUsingSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) return true;

            set.add(nums[i]);

            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1}; int k = 3;

        System.out.println(containsDuplicateII(arr, k));
        System.out.println(containsDuplicateIIUsingSlidingWindow(arr, k));
    }
}
