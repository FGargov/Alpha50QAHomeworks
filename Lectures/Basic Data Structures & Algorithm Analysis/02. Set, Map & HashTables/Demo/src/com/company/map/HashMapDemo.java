package com.company.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> studentAgeMap = new HashMap<>();

        studentAgeMap.put("John", 21);
        studentAgeMap.put("Bill", 18);
        studentAgeMap.put("William", 30);
        studentAgeMap.put("Besho", 21);

        System.out.println(studentAgeMap);

        // find the age of John (the value) via his name (the key)
        System.out.println(studentAgeMap.get("John"));

        // check if the map contains a value with the given key
        System.out.println(studentAgeMap.containsKey("Walter"));

        // get all values in the map as a collection

        System.out.println(studentAgeMap.values());

        // find the value for the given key. if there is no value, return the default value
        System.out.println(studentAgeMap.getOrDefault("Walter",0));
        System.out.println(studentAgeMap.getOrDefault("William",0));

        // if the key is not in the map, add it with the given value
        studentAgeMap.putIfAbsent("William", 21);
        System.out.println(studentAgeMap);

        Collection<String> namesWithB = studentAgeMap.keySet()
                .stream()
                .filter(key -> key.startsWith("B"))
                .collect(Collectors.toList());

        System.out.println(namesWithB);

       Collection<Integer> numbersWith21 = studentAgeMap.values()
                .stream()
                .filter(value -> value == 21)
                .collect(Collectors.toList());

        System.out.println(numbersWith21);



        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);

// Добавя "Three" -> 3, тъй като "Three" още не е в картата
        numbers.putIfAbsent("Three", 3);

// Не променя картата, тъй като "One" вече е в картата
        numbers.putIfAbsent("One", 11);

        System.out.println(numbers); // Извежда {One=1, Two=2, Three=3}
    }
}
