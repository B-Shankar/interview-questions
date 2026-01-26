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

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "A"));
        employees.add(new Employee(2, "B"));
        employees.add(new Employee(1, "C"));
        employees.add(new Employee(3, "D"));
        employees.add(new Employee(2, "E"));

        System.out.println("Input: " + employees);

        List<Employee> duplicates = findDuplicatesById(employees);

        System.out.println("Duplicates by id: " + duplicates);
    }
}
