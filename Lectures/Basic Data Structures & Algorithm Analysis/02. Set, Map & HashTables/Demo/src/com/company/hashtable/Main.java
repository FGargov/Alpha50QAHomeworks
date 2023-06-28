package com.company.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put("Ivan", "Sales");
        hashTable.put("Petar", "Marketing");
        hashTable.put("Gosho", "Marketing");
        hashTable.put("Dimitar", "Sales");

        hashTable.put("Ivan", "Marketing"); // Тъй като вече има двойка с ключ "Ivan" в хеш таблицата, тази операция не променя таблицата (според текущата имплементация на put метода).
        System.out.println(hashTable);

        String str1 = "FB";
        String str2 = "Ea";

        System.out.println(str1.hashCode()); // Извежда 64578
        System.out.println(str2.hashCode()); // Извежда 64578

        hashTable.put("FB", "asd");
        hashTable.put("Ea", "Easdasda");
    }
}
