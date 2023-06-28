package com.company.oop.polymorphism;

public class Staff extends User {
    private int staffId;

    public Staff(String name, int staffId) {
        super(name);
        this.staffId = staffId;
    }

    public int getStaffId() {
        return staffId;
    }

    @Override
    public String identify() {
        return String.format("%s #%d", super.identify(), getStaffId());
    }

    @Override
    public String toString() {
        return String.format("%s, %nStaffId: %d", super.toString(), getStaffId());
    }
}
