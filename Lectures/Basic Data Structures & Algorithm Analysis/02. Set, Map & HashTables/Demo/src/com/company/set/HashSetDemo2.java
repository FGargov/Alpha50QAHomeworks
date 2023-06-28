package com.company.set;

import com.company.Employee;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo2 {
    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();

        employees.add(new Employee("Ivan", "Ivanov", "Sales"));
        employees.add(new Employee("Ivan", "Petrov", "Sales"));

        // if Employee does not override equals() and hashCode() Ivan Ivanov will be added again to the Set
        employees.add(new Employee("Ivan", "Ivanov", "Sales"));

        System.out.println(employees);
    }
}
