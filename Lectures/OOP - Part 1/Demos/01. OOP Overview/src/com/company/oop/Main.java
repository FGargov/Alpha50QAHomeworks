package com.company.oop;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "John";
        person1.sayName();
        // Hi, my name is John.

        Person person2 = new Person();
        person2.name = "Jill";
        person2.sayName();
        // Hi, my name is Jill.
    }
}
