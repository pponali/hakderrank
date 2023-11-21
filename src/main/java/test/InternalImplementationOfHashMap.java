package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prakashponali
 * @Date 09/10/23
 */
public class InternalImplementationOfHashMap {

    public static void main(String[] args) {
        System.out.println(System.identityHashCode("prakash"));
        HashMap<String, String> map = new HashMap<>();

        Employee e1 = new Employee("emp1", "1", 14563456);
        Employee e2 = new Employee("emp2", "2", 2000);
        Employee e3 = new Employee("emp3", "1", 1000);
        Employee e4 = new Employee("emp4", "2", 20400);
        Employee e5 = new Employee("emp5", "1", 10050);
        Employee e6 = new Employee("emp6", "2", 20400);
        Employee e7 = new Employee("emp7", "1", 13000);
        Employee e8 = new Employee("emp8", "2", 20070);
        Employee e9 = new Employee("emp9", "1", 10200);
        Employee e10 = new Employee("emp10", "2", 295000);
        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);
        list.add(e7);
        list.add(e8);
        list.add(e9);
        list.add(e10);
        list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(System.identityHashCode(e1.id));
        System.out.println(System.identityHashCode(e2.id));
        map.put(e1.id, e1.name);
        map.put(e2.id, e2.name);
        System.out.println(System.identityHashCode(e1.id));
        System.out.println(System.identityHashCode(e2.id));
        System.out.println(map.get(e2.id));


    }


    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class Employee {
        String name;
        String id;
        double salary;
    }

}
