package com.company.oop.finalprimitivevsreference;

public class Person {
    private static int numberOfCreatedPersons = 0;

    private String name;
    private final int id;

    public Person(String name) {
        this.name = name;
        //id is final and should be initialized before the constructor of the object finish
        id = Person.numberOfCreatedPersons++;
    }

    public void setName(String name) {
        this.name = name;
    }

   /*public void setId(int id) { // id is final and setter is not allowed - error
        this.id = id;
    }*/
}
