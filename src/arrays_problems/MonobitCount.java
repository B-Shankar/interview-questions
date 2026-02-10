package arrays_problems;

public class MonobitCount {

    public static int countMonobitIntegers(int n) {

        int count = 1; // include 0

        long val = 1; // represents 2^k - 1

        while (val <= n) {
            count++;
            val = (val << 1) | 1; // generate next: 1,3,7,15,...
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countMonobitIntegers(5));
    }
}
