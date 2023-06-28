package com.company.oop.comparison;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Person p) {
        if (p == null) {
            return false;
        }
        return age == p.age && name.equals(p.name);
    }
}
