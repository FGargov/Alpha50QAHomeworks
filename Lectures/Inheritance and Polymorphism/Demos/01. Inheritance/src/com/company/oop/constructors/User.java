package com.company.oop.constructors;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
        System.out.println("User constructor - ready");
    }

    public String getName() {
        return name;
    }

    public String identify() {
        return String.format("Name: %s", getName().toUpperCase());
    }
}
