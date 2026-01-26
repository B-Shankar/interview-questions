package collections_problems;

import java.util.Iterator;

// Q11. Concurrent Modification Problem [ADVANCE]
/*
Why this throws error?

    for(String s : list){
        list.remove(s);
    }

    Fix it using:
        Iterator
        removeIf()
*/
import java.util.*;

public class ConcurrentModificationProblem {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("xyz");
        list.add("abc");
        list.add("pqr");

        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("abc")) {
                it.remove();   // safe removal
            }
        }

        System.out.println("After removal: " + list);
    }
}

/*
    Why Does This Error Happen?
    This loop is actually using an Iterator internally:

    Iterator<String> it = list.iterator();

    When loop runs:
        Iterator expects list not to change
        But list.remove() modifies the list directly

    So:
        Iterator detects modification
        Throws ConcurrentModificationException
        This is Java’s fail-fast behavior to prevent unpredictable bugs.
*/