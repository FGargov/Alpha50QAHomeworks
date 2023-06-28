package com.gargov;

public class Main {
    public static void main(String[] args) {
        /*Person person1 = new Person();
        person1.name = "Goshko";
        person1.sayName();

        Person person2 = new Person();
        person2.name = "Nachko";
        person2.sayName();*/

        /*Person ivan = new Person("Ivan", 32, "0887307230");
        System.out.printf("Ivan is %d%n", ivan.getAge());
        ivan.setAge(33);
        System.out.printf("Ivan is %d%n", ivan.getAge());*/

        //Person unknown = new Person();
//        System.out.println(unknown.name);
//        System.out.println(unknown.getAge());
       // System.out.println(unknown.phone);

     /*   ivan.introduce();
        ivan.shareContact();*/

        Person p1 = new Person("Ivan", 23);
        Person p2 = new Person("Ivan", 23);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
    }
}
