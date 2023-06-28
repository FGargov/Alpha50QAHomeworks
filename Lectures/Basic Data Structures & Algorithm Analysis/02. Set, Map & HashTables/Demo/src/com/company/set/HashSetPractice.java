package com.company.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetPractice {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();

        names.add("John");
        names.add("Jimmy");
        names.add("Chandler");
        names.add("Chris");

        System.out.println(names.size());

        names.add("Jimmy");
        System.out.println(names.size());

        System.out.println(names.add("Zach"));
        System.out.println(names.add("Jimmy"));

        Set<String> moreNames = new HashSet<>();
        moreNames.add("Jimmy");
        moreNames.add("Frank");
        moreNames.add("Chandler");
        moreNames.add("Chris");
        moreNames.retainAll(names);
        System.out.println(moreNames);

        Set<String> namesWithS = names
                .stream()
                .filter(name -> name.contains("C"))
                .collect(Collectors.toSet()); // събираме резултата в един лист.

        System.out.println(namesWithS);

        List<Character> characters = List.of('a', 'b', 'c', 'd', 'e', 'd');
        Set<Character> characterSet = characters
                .stream()
                .collect(Collectors.toSet()); // Set не може да има повтарящи се символи.
        System.out.println(characterSet);
    }
}
