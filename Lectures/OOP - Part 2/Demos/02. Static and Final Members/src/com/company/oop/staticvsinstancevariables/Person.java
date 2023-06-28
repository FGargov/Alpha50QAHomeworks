package com.company.oop.staticvsinstancevariables;

public class Person {
    //nextId is static variable it belongs to the class
    private static int nextId = 0;

    //id is instance variable and belongs to the objects created from this class
    private int id;
    private String name;

    public Person(String name) {
        id = Person.nextId++;
        this.name = name;
    }

    public static int getPeopleCount() {
        return Person.nextId;
    }

    public int getId() {
        return id;
    }
}
