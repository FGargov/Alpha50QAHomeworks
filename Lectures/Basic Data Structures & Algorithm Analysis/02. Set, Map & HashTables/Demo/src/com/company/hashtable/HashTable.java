package com.company.hashtable;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable {
    private final LinkedList<KeyValuePair>[] elements;

    public HashTable() {
        elements = new LinkedList[10];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new LinkedList<>();
        }
    }

    public void put(String key, String value) {
        int index = getIndex(key);
        for (KeyValuePair element : elements[index]) {
            if (element.key.equals(key)) {
                return;
            }
        }
        elements[index].add(new KeyValuePair(key, value));
    }

    public String get(String key) {
        int index = getIndex(key);
        for (KeyValuePair element : elements[index]) {
            if (element.key.equals(key)) {
                return element.value;
            }
        }

        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LinkedList<KeyValuePair> list : elements) {
            for (KeyValuePair element : list) {
                result.append(String.format("(%s: %s)%n", element.key, element.value));
            }
        }
        return result.toString();
    }

    private int getIndex(String key) {
        return Math.abs(key.hashCode()) % elements.length;
    }

    private class KeyValuePair {
        String key;
        String value;

        KeyValuePair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
