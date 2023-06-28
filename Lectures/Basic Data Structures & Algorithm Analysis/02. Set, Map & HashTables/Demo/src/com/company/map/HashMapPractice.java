package com.company.map;

import com.company.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HashMapPractice {
    public static void main(String[] args) {
        Map<String, Integer> studentAgeMap = new HashMap<>();

        studentAgeMap.put("John", 21);
        studentAgeMap.put("Bill", 18);
        studentAgeMap.put("William", 30);
        System.out.println(studentAgeMap);
        System.out.println(studentAgeMap.containsKey("John"));
        System.out.println(studentAgeMap.containsKey("John123"));
        System.out.println(studentAgeMap.values());
        System.out.println(studentAgeMap.getOrDefault("Walter", 0));
        studentAgeMap.putIfAbsent("Pesho", 25);
        System.out.println(studentAgeMap.containsKey("Pesho"));

        Map<String, List<Employee>> departmentEmployeeMap = new TreeMap<>();
        Employee employee1 = new Employee("John", "Preacher", "Sales");
        Employee employee2 = new Employee("Monica", "Lewis", "IT");
        Employee employee3 = new Employee("Sylvia", "Richards", "IT");
        Employee employee4 = new Employee("Davide", "Silva", "Accounting");
        Employee employee5 = new Employee("Lee", "Wi", "Finance");
        Employee employee6 = new Employee("Lewis", "Law", "Sales");

        departmentEmployeeMap.put("Sales", List.of(employee1, employee6));
        departmentEmployeeMap.put("IT", List.of(employee2, employee3));
        departmentEmployeeMap.put("Accounting", List.of(employee4));
        departmentEmployeeMap.put("Finance", List.of(employee5));

        System.out.println(departmentEmployeeMap.get("Sales"));


        Map<String, List<Employee>> departmentEmployeeTreeMap = new TreeMap<>();

        Employee employee11 = new Employee("John", "Preacher", "Sales");
        Employee employee22 = new Employee("Monica", "Lewis", "IT");
        Employee employee33 = new Employee("Sylvia", "Richards", "IT");
        Employee employee44 = new Employee("Davide", "Silva", "Accounting");
        Employee employee55 = new Employee("Lee", "Wi", "Finance");
        Employee employee66 = new Employee("Lewis", "Law", "Sales");

        departmentEmployeeTreeMap.put("Sales", List.of(employee11, employee66));
        departmentEmployeeTreeMap.put("IT", List.of(employee22, employee33));
        departmentEmployeeTreeMap.put("Accounting", List.of(employee44));
        departmentEmployeeTreeMap.put("Finance", List.of(employee55));

        // query all employees who work in Sales
        System.out.println(departmentEmployeeTreeMap.get("Sales"));
    }
}
