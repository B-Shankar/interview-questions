package arrays_problems;

// 941. Valid Mountain Array
public class ValidMountainArray {

    static public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int left = 0, right = n - 1;

        // move up
        while (left + 1 < n && arr[left] < arr[left + 1]) {
            left++;
        }

        // move down
        while (right - 1 >= 0 && arr[right] < arr[right - 1]) {
            right--;
        }

        // peak should be same and not edges
        return left > 0 && right < n - 1 && left == right;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,2,1};

        System.out.println(validMountainArray(arr));
    }
}
