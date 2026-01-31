package arrays_problems;

// 744. Find Smallest Letter Greater Than Target
public class FindSmallest {

    public static char nextGreatestLetter(char[] arr, char target) {
        int left = 0, right = arr.length - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return arr[left % arr.length];
    }

    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};

        System.out.println("ANS: " + nextGreatestLetter(arr, 'c'));
    }
}
