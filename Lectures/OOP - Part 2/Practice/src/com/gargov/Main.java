package com.gargov;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Pesho");
        Person p2 = new Person("Gosho");
        Person p3 = new Person("asdasd");
        Person p4 = new Person("Goshasdasdasdasdo");

        System.out.println(p1.getId());
        System.out.println(Person.getPeopleCount());
        System.out.println(p2.getId());
        System.out.println(Person.getPeopleCount());
        System.out.println(p3.getId());
        System.out.println(Person.getPeopleCount());
        System.out.println(p4.getId());
        System.out.println(Person.getPeopleCount());
    }
}