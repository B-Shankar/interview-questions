package arrays_problems;

import java.util.Arrays;

// 976. Largest Perimeter Triangle

// NOTE: Property of a triangle is  a+b>c,b+c>a, c+a>b
public class LargestPerimeterTriangle {

    static int largestPerimeterTriangle(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = n - 3; i >= 0; i--) {
            if (arr[i] + arr[i + 1] > arr[i + 2])
                return arr[i] + arr[i + 1] + arr[i + 2];
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        System.out.println(largestPerimeterTriangle(arr));
    }
}
