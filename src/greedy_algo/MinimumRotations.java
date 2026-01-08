package greedy_algo;

// Minimum rotations to unlock a circular lock

import java.util.Scanner;

//You are given a lock which is made up of n-different circular rings and each ring has 0-9 digit printed serially on it. Initially all n-rings together show a n-digit integer but there is particular code only which can open the lock. You can rotate each ring any number of time in either direction. You have to find the minimum number of rotation done on rings of lock to open the lock.
public class MinimumRotations {

    int minRotations(int inputCode, int lockCode) {

        int rotations = 0;
        while (inputCode > 0 || lockCode > 0) {

            int inputDigit = inputCode % 10;
            int lockDigit = lockCode % 10;

            rotations += Math.min(Math.abs(inputDigit - lockDigit), 10 - Math.abs(inputDigit - lockDigit));

            inputCode /= 10;
            lockCode /= 10;
        }

        return rotations;
    }

    public static void main(String[] args) {
        MinimumRotations minimumRotations = new MinimumRotations();

        Scanner input = new Scanner(System.in);
        System.out.println("Input Code: ");
        int inputCode = input.nextInt();
        System.out.println("Lock Code: ");
        int lockCode = input.nextInt();

        int ans = minimumRotations.minRotations(inputCode, lockCode);

        System.out.println("ans: " + ans);
    }
}
