package collections_problems;

// Q4. Sort List Without Using Collections.sort()

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

//Input: [5, 1, 4, 2]
//Sort using TreeSet or custom logic.

// IMPORTANT: TreeSet Removes Duplicates
public class SortList {

    private static List<Integer> SortUsingTreeSet(List<Integer> list) {

        List<Integer> result = new ArrayList<>( new TreeSet<>(list));
        return result;
    }

    private static List<Integer> bubbleSort(List<Integer> list) {

        boolean swapped;

        for (int i = 0; i < list.size() - 1; i++) {

            swapped = false;

            for (int j = 1; j < list.size() - i; j++) {

                if (list.get(j - 1) > list.get(j)) {

                    int temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);

                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(3);

        TreeSet<Integer> sortList = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            sortList.add(list.get(i));
        }

        System.out.println("Input List: " + list);
        System.out.println("Sorted List: " + sortList);
        System.out.println("Sorted List: " + SortUsingTreeSet(list));

        //Bubble sort
        System.out.println("Input List: " + list);
        System.out.println("Bubble sort: " + bubbleSort(list));

        //Using Collections
        System.out.println("Input List: " + list);
        Collections.sort(list);
        System.out.println("Sorted List: "+ list);

    }
}
