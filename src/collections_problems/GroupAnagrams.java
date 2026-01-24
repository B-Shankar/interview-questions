package collections_problems;

import java.util.*;

// Q5. Group Anagrams

//Input: ["eat","tea","tan","ate","nat","bat"]
//Output:
//    [
//        ["eat","tea","ate"],
//        ["tan","nat"],
//        ["bat"]
//    ]

//    Use: HashMap<String, List<String>>

public class GroupAnagrams {

    private static Map<String, List<String>> groupAnagrams(List<String> anagrams) {

        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < anagrams.size(); i++) {
            String value = anagrams.get(i);

            char[] chars = value.toCharArray();
            Arrays.sort(chars);

            String backToString = new String(chars);

            if (result.containsKey(backToString)) {
                List<String> list = result.getOrDefault(backToString, new ArrayList<>());
                list.add(value);
                result.put(backToString, list);
            } else {
                result.put(backToString, new ArrayList<>(List.of(value)));
            }
        }

        return result;
    }

    private static Map<String, List<String>> groupAnagramsOptimised(List<String> anagrams) {

        Map<String, List<String>> result = new HashMap<>();

        for (String word : anagrams) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            result.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> anagrams = new ArrayList<>(List.of("eat","tea","tan","ate","nat","bat"));

        System.out.println("Input: " + anagrams);

        Map<String, List<String>> map = groupAnagrams(anagrams);
        Map<String, List<String>> mapNew = groupAnagramsOptimised(anagrams);

        System.out.println("Output: " + map.values());
        System.out.println("Output: " + mapNew.values());
    }
}
