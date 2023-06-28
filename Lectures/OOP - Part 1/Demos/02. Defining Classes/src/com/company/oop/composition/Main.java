package com.company.oop.composition;

public class Main {
    public static void main(String[] args) {
        // Create address
        Address address = new Address("Pirotska", 42);

        // Create person
        Person person = new Person("Gosho", address);

        System.out.println(person.getInfo());
    }
}
