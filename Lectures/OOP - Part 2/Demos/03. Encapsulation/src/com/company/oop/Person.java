package com.company.oop;

public class Person {
    private static final int NAME_MIN_LENGTH = 3;
    private static int nextId = 0;

    // Fields should be private
    private final int id;
    private String name;

    public Person(String name) {
        id = Person.nextId++;
        setName(name);
    }

    //Getters usually are public
    public int getId() {
        return id;
    }

    //Getters usually are public
    public String getName() {
        return name;
    }

    //Setters could have any access modifier, but it is recommended
    //to start with private and then give more access if we need.
    private void setName(String name) {
        //Setters usually have validation functionality
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
