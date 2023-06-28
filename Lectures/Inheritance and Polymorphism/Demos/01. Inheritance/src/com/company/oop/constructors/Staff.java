package com.company.oop.constructors;

public class Staff extends User {
    private int staffId;

    public Staff(String name, int staffId) {
        //with super(name); we call the constructor of the base class (User) and pass the required parameter
        super(name);
        this.staffId = staffId;
        System.out.println("Staff constructor - ready");
    }

    public int getStaffId() {
        return staffId;
    }

    @Override
    public String identify() {
        //with super.identify() we call the identify method in the base class (User)
        return String.format("%s #%d", super.identify(), getStaffId());
    }
}
