package collections_problems;

// Q10. Find Duplicate Objects by Field [ADVANCE]
/*
    class Employee {
       int id;
       String name;
    }
    Find duplicate employees by id.

    Use: HashSet or Map<Integer, Employee>
*/

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + name + ")";
    }
}

public class FindDuplicateObject {

    public static List<Employee> findDuplicatesById(List<Employee> list) {

        Set<Integer> seen = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee e : list) {
            if (!seen.add(e.id)) {   // add() returns false if already present
                duplicates.add(e);
            }
        }

        return duplicates;
    }

    public static List<Employee> findAllDuplicateEmployees(List<Employee> list) {

        Map<Integer, List<Employee>> map = new HashMap<>();

        for (Employee e : list) {
            map.computeIfAbsent(e.id, k -> new ArrayList<>()).add(e);
        }

        List<Employee> result = new ArrayList<>();

        for (List<Employee> group : map.values()) {
            if (group.size() > 1) {
                result.addAll(group);
            }
        }

        return result;
    }

    public static List<Employee> duplicates(List<Employee> list) {
        List<Employee> duplicates =
                list.stream()
                        .collect(Collectors.groupingBy(e -> e.id))
                        .values().stream()
                        .filter(g -> g.size() > 1)
                        .flatMap(List::stream)
                        .toList();

        return duplicates;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "A"));
        employees.add(new Employee(2, "B"));
        employees.add(new Employee(1, "C"));
        employees.add(new Employee(3, "D"));
        employees.add(new Employee(2, "E"));

        System.out.println("Input: " + employees);

        List<Employee> duplicates = findDuplicatesById(employees);
        List<Employee> dups = findAllDuplicateEmployees(employees);
        List<Employee> dupsA = duplicates(employees);

        System.out.println("Duplicates by id: " + duplicates);
        System.out.println("Duplicates by id: " + dups);
        System.out.println("Duplicates by id: " + dupsA);
    }
}
