package collections_problems;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

// Q1. Remove Duplicates from List

// Given a List<Integer>, remove duplicates and keep insertion order.
// Solution: LinkedHashSet
public class RemoveDuplicates {

    //function to remove duplicates and keep insertion order
    private static LinkedHashSet<Integer> removeDuplicates(List<Integer> list) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();

        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i));
        }

        return result;
    }

    //optimised
    private static List<Integer> removeDuplicatesOptimized(List<Integer> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);
        list.add(5);
        list.add(10);
        list.add(14);
        list.add(13);
        list.add(14);
        list.add(13);
        list.add(10);
        list.add(8);

        System.out.println("Input: " + list);
        System.out.println("Output: " + removeDuplicates(list));
        System.out.println("Output: " + removeDuplicatesOptimized(list));
    }
}
