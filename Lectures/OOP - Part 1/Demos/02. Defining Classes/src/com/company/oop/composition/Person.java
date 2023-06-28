package com.company.oop.composition;

public class Person {
    private String name;
    private Address homeAddress;

    public Person(String name, Address homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }

    public String getInfo() {
        return String.format("I am %s and I live on %s", name, homeAddress.getInfo());
    }
}
