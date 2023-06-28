package com.company.oop;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ivan");
        System.out.printf("%d %s%n", p1.getId(), p1.getName());

        Person p2 = new Person("Petar");
        System.out.printf("%d %s%n", p2.getId(), p2.getName());

        //This code will terminate the program because the name in not valid
        //Person p3 = new Person("A");
    }
}
