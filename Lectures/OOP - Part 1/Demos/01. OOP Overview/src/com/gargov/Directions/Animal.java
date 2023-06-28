package com.gargov.Directions;

public class Animal {
    String name;
    String type;
    double age;

    public Animal(String name, String type, double age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
