package arrays_problems;

import java.util.*;

// 49. Group Anagrams
public class GroupAnagrams {

    static List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {

            int[] frequency = new int[26];

            for (char c : str.toCharArray()) {
                frequency[c-'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append("#");
                key.append(frequency[i]);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    static List<List<String>> groupAnagramWithSorting(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            String value = strs[i];

            char[] arr = strs[i].toCharArray();

            Arrays.sort(arr);

            String key = Arrays.toString(arr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagram(strs));
        System.out.println(groupAnagramWithSorting(strs));
    }
}
