package com.company.conditionaloperators;

public class LogicalOperators {
    public static void main(String[] args) {
        String name = "Pesho";
        int age = 17;
        System.out.println(name.equals("Pesho") && age > 18);  // false
        System.out.println(name.equals("Pesho") || age > 18);  // true
        System.out.println(age > 10 && age < 22);              // true
        System.out.println(!(name.equals("Pesho")));           // false
    }
}
