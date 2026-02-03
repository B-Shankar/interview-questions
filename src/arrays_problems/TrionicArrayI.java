package arrays_problems;

// 3637. Trionic Array I
public class TrionicArrayI {

    private static boolean trionicArray(int[] arr) {

        if (arr.length == 0) return false;

        int p = -1, q = -1, r = -1;
        int phase = 0;

        if (arr.length < 4) return false;

        for (int i = 0; i < arr.length - 1; i++) {

            if (phase == 0) {
                if (arr[i] < arr[i + 1]) {
                    p = i + 1;
                } else {
                    phase++;
                    q = i + 1;
                }
            } else if (phase == 1) {
                if (arr[i] > arr[i + 1]) {
                    q = i + 1;
                } else {
                    phase++;
                    r = i + 1;
                }
            } else if (phase == 3) {
                if (arr[i] < arr[i + 1]) {
                    r = i + 1;
                } else {
                    return false;
                }
            }

        }

        return (p > 0) && (q > p) && (r == arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,2,6};

        System.out.println("Trionic Array: " + trionicArray(arr));
    }
}
