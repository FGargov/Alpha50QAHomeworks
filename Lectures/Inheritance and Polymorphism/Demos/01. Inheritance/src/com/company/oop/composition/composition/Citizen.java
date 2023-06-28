package com.company.oop.composition.composition;

public class Citizen {
    public String name;
    private Address address;

    public Citizen(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s lives %s, %s", name, address.getCity(), address.getStreet());
    }
}
