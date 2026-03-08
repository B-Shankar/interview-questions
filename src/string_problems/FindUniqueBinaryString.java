package string_problems;

// 1980. Find Unique Binary String
public class FindUniqueBinaryString {

    static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i) == '0')
                result.append('1');
            else
                result.append('0');

        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"01","10"};

        System.out.println(findDifferentBinaryString(strs));
    }
}
