package arrays_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 2007. Find Original Array From Doubled Array
public class OriginalArrayFromDoubledArray {

    public static int[] findOriginalArray(int[] changed) {

        int n = changed.length;
        if (n % 2 != 0) return new int[]{};

        Arrays.sort(changed);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[n / 2];
        int index = 0;

        for (int num : changed) {

            if (map.get(num) == 0) continue;

            int twice = num * 2;

            // special case when num == twice (0)
            if (num == twice) {
                if (map.get(num) < 2) return new int[]{};

                map.put(num, map.get(num) - 2);
                result[index++] = num;
                continue;
            }

            if (!map.containsKey(twice) || map.get(twice) == 0) {
                return new int[]{};
            }

            map.put(num, map.get(num) - 1);
            map.put(twice, map.get(twice) - 1);

            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,6,8};
        System.out.println(Arrays.toString(findOriginalArray(arr)));
    }
}
