package com.company.oop.constructors;

public class Main {
    public static void main(String[] args) {
        Person jack = new Person("Jack");
        jack.sayName();// Hi, I'm Jack.

        Person unknown = new Person();
        unknown.sayName(); // Hi, I'm Anonymous.
    }
}
