package com.company.map;

import com.company.Employee;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
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

        // query all employees who work in Sales
        System.out.println(departmentEmployeeMap.get("Sales"));
    }
}
