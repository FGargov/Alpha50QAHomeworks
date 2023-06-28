package com.company.oop.comparison;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ivan", 23);
        Person p2 = new Person("Ivan", 23);

        //p1 and p2 contains different addresses
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);      // false

        //p1 and p2 are pointing to different objects
        // but those objects have same age and name - therefore equals returns true
        System.out.println(p1.equals(p2)); // true
    }
}
