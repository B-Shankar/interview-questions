package string_problems;

// 693. Binary Number with Alternating Bits
public class BinaryAlternatingBits {
    public static boolean hasAlternatingBits1(int n) {
        String bits = Integer.toBinaryString(n);

        int floorLog2 = (int)(Math.log(n) / Math.log(2));
        for (int i = 0; i < floorLog2; i++) {
            if (bits.charAt(i) == bits.charAt(i + 1))
                return false;
        }

        return true;
    }

    public static boolean hasAlternatingBits2(int n) {
        int currBit = n % 2;
        n /= 2;

        while (n > 0) {
            if (currBit == n % 2)
                return false;

            currBit = n % 2;
            n /= 2;
        }
        return true;
    }

    public static boolean hasAlternatingBits(int n) {
        int result = n ^ (n >> 1);

        return (result & (result + 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits1(5));
        System.out.println(hasAlternatingBits2(5));
    }
}
