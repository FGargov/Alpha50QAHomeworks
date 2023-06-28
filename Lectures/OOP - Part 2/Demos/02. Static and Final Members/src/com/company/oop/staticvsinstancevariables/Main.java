package com.company.oop.staticvsinstancevariables;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Pesho");
        Person p2 = new Person("Gosho");
        System.out.println(p1.getId());
        System.out.println(Person.getPeopleCount());
    }
}
