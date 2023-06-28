package com.company.set;

import com.company.Employee;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Employee> employees = new TreeSet<>();

        employees.add(new Employee("Zach", "Brown", "Sales"));
        employees.add(new Employee("Tim", "Apple", "Finance"));
        employees.add(new Employee("Tom", "Jeferson", "Transportation"));
        employees.add(new Employee("Andy", "Thompson", "Sales"));

        // the employees are sorted based on the comparator we define
        System.out.println(employees);
    }
}
