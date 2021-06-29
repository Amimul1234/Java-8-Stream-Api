package stream2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSort {
    public static void main( String[] args ) {

        List<String> fruits = getFruits();

        //Ascending order sort
        fruits.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Ascending order sort
        fruits.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);


        List<Employee> employeeList = getEmployeeList();

        //Sort employee by salary asc
        employeeList.stream().sorted(Comparator.comparingLong(Employee::salary))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Sort employee by salary desc
        employeeList.stream().sorted(Comparator.comparingLong(Employee::salary).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Sort employee by age asc
        employeeList.stream().sorted(Comparator.comparing(Employee::age))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static List<String> getFruits() {

        List<String> fruits = new ArrayList<>();

        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        return fruits;
    }

    public static List<Employee> getEmployeeList() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(10, "Ramesh", 30, 400000));
        employeeList.add(new Employee(20, "Santosh", 29, 350000));
        employeeList.add(new Employee(30, "Sanjay", 30, 450000));
        employeeList.add(new Employee(40, "Pramod", 29, 500000));

        return employeeList;
    }
}

record Employee(int id, String name, int age, long salary) {

}
