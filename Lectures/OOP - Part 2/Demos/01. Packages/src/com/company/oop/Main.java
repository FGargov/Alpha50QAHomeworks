package com.company.oop;

import com.company.oop.package1.Class1;
import com.company.oop.package1.Class2;
import com.company.oop.package2.Class5;
import com.company.oop.package2.Class4;

public class Main {
    public static void main(String[] args) {
        Class1 obj1 = new Class1();
        Class2 obj2 = new Class2();

        // Class3 can't be imported because it has package private access modifier.
        //Class3 obj3 = new Class3();

        Class4 obj4 = new Class4();
        Class5 obj5 = new Class5();
    }
}
