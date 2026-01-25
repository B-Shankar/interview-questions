package collections_problems;

import java.util.*;

// Q9. Sort Map by Values [ADVANCE]

//Input: {A=3, B=1, C=2}
//Output: {B=1, C=2, A=3}
//USE: Convert entrySet → List → sort → LinkedHashMap

// NOTE:
// 1. Map is not sortable.
// 2. It has no order (especially HashMap)
public class SortMap {

    /*
        how to sort map by values ?
        Convert map.entrySet() to a list, sort the list using comparator on values, then store entries in LinkedHashMap to preserve sorted order.
    */
    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {

        // Step 1: entrySet -> List
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        System.out.println(list);

        // Step 2: sort list by value
        list.sort(Map.Entry.comparingByValue());

        System.out.println(list);

        // Step 3: put into LinkedHashMap to maintain order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sortedMap);

        return sortedMap;
    }

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 3);
        map.put("B", 1);
        map.put("C", 2);

        System.out.println(sortByValue(map));
    }

}
