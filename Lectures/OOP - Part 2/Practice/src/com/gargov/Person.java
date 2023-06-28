package com.gargov;

public class Person {
    private static int nextId = 0;

    private int id;
    private String name;

    public Person(String name) {
        this.name = name;
        this.id = Person.nextId++;
    }

    public int getId() {
        return id;
    }

    public static int getPeopleCount() {
        return Person.nextId;
    }
}
