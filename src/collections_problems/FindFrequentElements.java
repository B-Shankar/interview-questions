package collections_problems;

// Q6. Find Top K Frequent Elements [MEDIUM]

// Input: [1,1,1,2,2,3], k = 2
// Output: [1,2]

import java.util.*;

// Use: HashMap + PriorityQueue
public class FindFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        // Step 1: Frequency Map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        System.out.println(freq);

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        System.out.println(heap);

        // Step 3: Keep only top K
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll(); // remove smallest frequency
            }
        }

        System.out.println(heap);

        // Step 4: Extract result
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> value = topKFrequent(arr, k);
        System.out.println(value);
    }
}