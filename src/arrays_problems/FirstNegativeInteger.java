package arrays_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// First negative in every window of size k
public class FirstNegativeInteger {

    static int[] firstNegativeInt(int[] arr, int k) {
        int n = arr.length;

        int i = 0, j = 0;

        Queue<Integer> negativesStore = new LinkedList<>();

        int[] result = new int[n - k + 1];
        int resultIdx = 0;

        while (j < n) {
            int value = arr[j];

            if (value < 0)
                negativesStore.add(value);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // 1. calculate ans
                if (negativesStore.isEmpty()) {
                    result[resultIdx++] = 0;
                } else {
                    result[resultIdx++] = negativesStore.peek();

                    // if match slide
                    if (negativesStore.peek() == arr[i]) {
                        negativesStore.remove();
                    }
                }

                // 2. slide window
                i++;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;

        System.out.println(Arrays.toString(firstNegativeInt(arr, k)));
    }
}
