package collections_problems;

// Q3. Find First Non-Repeating Character

import java.util.LinkedHashMap;
import java.util.Map;

// Input: "swiss"
// Output: w
// Use: LinkedHashMap
public class FirstNonRepeatingChar {

    private static char firstNonRepeatingChar(String s) {
        char[] arr = s.toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c: arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

//        System.out.println("entrySet" + map.entrySet());
//        System.out.println("keySet" + map.keySet());
//        System.out.println("valueSet" + map.values());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }

        return '\0';
    }

    public static void main(String[] args) {
        String s = "swiss";

        System.out.println("Input: " + s);
        System.out.println("Output: " + firstNonRepeatingChar(s));
    }
}
