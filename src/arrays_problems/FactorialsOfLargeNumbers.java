package arrays_problems;

import java.util.ArrayList;
import java.util.Arrays;

// Factorials of large numbers - GFG
public class FactorialsOfLargeNumbers {

    public static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(1);
        int size = 1;

        for (int multiplier = 2; multiplier <= n; multiplier++) {
            multiply(arr, multiplier, size);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            result.add(arr.get(i));
        }

        return result;
    }

    static void multiply(ArrayList<Integer> arr,  int multiplier, int size) {
        int carry = 0;

        for (int i = 0; i < size; i++) {
            int res = arr.get(i) * multiplier + carry;

            arr.set(i, res % 10);
            carry = res / 10;
        }

        while (carry > 0) {
            arr.add(carry % 10);
            carry /= 10;
        }
    }

    public static void main(String[] args) {
        System.out.println("Factorial : " + Arrays.toString(factorial(5).toArray()));
    }
}
