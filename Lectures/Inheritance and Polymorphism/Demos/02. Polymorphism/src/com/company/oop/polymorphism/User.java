package com.company.oop.polymorphism;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String identify() {
        return String.format("Name: %s", getName().toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("Name: %s", getName());
    }
}
