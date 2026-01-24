package collections_problems;

import java.util.HashMap;
import java.util.Map;
// Q2. Count Frequency of Characters

// Input: "aabbbcdd"
// Output: {a=2, b=3, c=1, d=2}

// Use: HashMap<Character, Integer>
public class CountFrequency {

    public static void main(String[] args) {
        String s = "aabbbcdd";

        HashMap<Character, Integer> result = new HashMap<>();

        char[] charArray = s.toCharArray();

        for (char c: charArray) {
            if (result.containsKey(c)) {
                result.put(c, result.get(c) + 1);
            } else {
                result.put(c, 1);
            }
        }
        System.out.println("result: " + result);
        System.out.println("result: " + characterCounter(s));
    }

    //optimised: Java 8+
    private static Map<Character, Integer> characterCounter(String s) {
        char[] ch = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}
