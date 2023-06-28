package com.company.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        stackDemo();
        stackWithArrayListDemo();
    }

    static void stackDemo() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1); // O(1)
        stack.push(2); // O(1)
        stack.push(3); // O(1)
        stack.push(4); // O(1)
        stack.push(5); // O(1)

        System.out.println(stack.peek()); // O(1)

        System.out.println(stack.pop());  // O(1)
        System.out.println(stack.pop());  // O(1)
        System.out.println(stack.pop());  // O(1)
    }

    static void stackWithArrayListDemo() {
        ArrayList<Integer> stackWithList = new ArrayList<>();

        // push
        stackWithList.add(1); // O(1)
        stackWithList.add(2); // O(1)
        stackWithList.add(3); // O(1)
        stackWithList.add(4); // O(1)
        stackWithList.add(5); // O(1)

        // peek
        System.out.println(stackWithList.get(stackWithList.size() - 1)); // O(1)

        // pop
        System.out.println(stackWithList.remove(stackWithList.size() - 1)); // O(1)
        System.out.println(stackWithList.remove(stackWithList.size() - 1)); // O(1)
        System.out.println(stackWithList.remove(stackWithList.size() - 1)); // O(1)
    }

    static void stackWithLinkedListDemo() {
        LinkedList<Integer> stackWithList = new LinkedList<>();

        // push
        stackWithList.addLast(1); // O(1)
        stackWithList.addLast(2); // O(1)
        stackWithList.addLast(3); // O(1)
        stackWithList.addLast(4); // O(1)
        stackWithList.addLast(5); // O(1)

        // peek
        System.out.println(stackWithList.getLast()); // O(1)

        // pop
        System.out.println(stackWithList.removeLast()); // O(1)
        System.out.println(stackWithList.removeLast()); // O(1)
        System.out.println(stackWithList.removeLast()); // O(1)
    }
}
