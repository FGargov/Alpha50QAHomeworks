package com.company.set;

import com.company.Employee;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HashSetDemo {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Jimmy");
        names.add("Chandler");
        names.add("Chris");

        // prints 3
        System.out.println(names.size());

        // "Jimmy" is already in the set, nothing changes
        names.add("Jimmy");

        // prints 3
        System.out.println(names.size());

        // add() returns boolean - true if the element was added and false if not
        System.out.println(names.add("Zach"));
        System.out.println(names.add("Jimmy"));

        Set<String> moreNames = new HashSet<>();
        moreNames.add("Jimmy");
        moreNames.add("Frank");

        // retainAll() returns all elements that appear on bot sets
        moreNames.retainAll(names);
        System.out.println(moreNames);

        // since the Set interface inherits from Collection, we can use it in a stream
        Set<String> namesWithS = names
                .stream()
                .filter(name -> name.contains("C"))
                .collect(Collectors.toSet());

        System.out.println(namesWithS);


        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("Ivan", "Ivanov", "Sales"));
        employees.add(new Employee("Ivan", "Petrov", "Sales"));

        employees.add(new Employee("Ivan", "Ivanov", "Sales"));
        System.out.println(employees);


        Set<Employee> employeesTwo = new TreeSet<>();
        employeesTwo.add(new Employee("Zach", "Brown", "Sales"));
        employeesTwo.add(new Employee("Tim", "Apple", "Finance"));
        employeesTwo.add(new Employee("Tom", "Jeferson", "Transportation"));
        employeesTwo.add(new Employee("Andy", "Thompson", "Sales"));

        // the employees are sorted based on the comparator we define
        System.out.println(employeesTwo);
    }
}
