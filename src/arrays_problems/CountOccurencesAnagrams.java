package arrays_problems;

import java.util.HashMap;
import java.util.Map;

// Count Occurences of Anagrams
public class CountOccurencesAnagrams {

    static int search(String pat, String txt) {
        int n = txt.length();

        int k = pat.length();

        int i = 0, j = 0;

        int occurance = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : pat.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }

        int count = map.size();

        while (j < n) {

            // calculation
            char ch = txt.charAt(j);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0)
                    count--;
            }


            if (j - i + 1  < k) {
                j++;
            } else if (j - i + 1 == k) {
                // condition
                if (count == 0)
                    occurance++;

                //slid window
                char leftChar = txt.charAt(i);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) == 1)
                        count++;
                }

                i++;
                j++;
            }

        }

        return occurance;
    }

    public static void main(String[] args) {
        String txt = "forxxorfxdofr", pat = "for";

        System.out.println(search(pat, txt));
    }
}
