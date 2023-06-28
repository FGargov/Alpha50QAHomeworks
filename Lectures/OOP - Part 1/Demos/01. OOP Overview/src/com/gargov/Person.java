package com.gargov;

public class Person {
    public String name;
    private int age;
    private String phone;

    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

  /*  public Person() {
        this("Unknown", 0, "00000000");
    }*/
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 1)
            this.age = age;
    }

    public void sayName() {
        System.out.printf("Hi, my name is %s%n", name);
    }

    public void introduce() {
        System.out.printf("Hey, i am %s and i am %d years old. %n", name, age);
    }

    public void shareContact() {
        System.out.printf("You can contact me at %s. %n", phone);
    }
    public boolean equals(Person p) {
        if (p == null) {
            return false;
        }
        return age == p.age && name.equals(p.name);
    }
}
