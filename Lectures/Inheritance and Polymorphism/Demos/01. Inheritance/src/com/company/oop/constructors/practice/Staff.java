package com.company.oop.constructors.practice;

public class Staff extends User {
        private int staffId;

        public Staff(String name, int staffId) {
            super(name);
            this.staffId = staffId;
            System.out.println("Staff constructor - ready");
        }

        public int getStaffId() {
            return this.staffId;
        }

        @Override
        public String identify() {
            return String.format("%s #%d", super.identify(), getStaffId());
        }
}
