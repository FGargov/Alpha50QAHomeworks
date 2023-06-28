package com.company.dsa;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        queueDemo();
    }

   /* static void queueDemo() {
        Queue<Integer> queue = new ArrayDeque<>(); // can be changed with LinkedList

        queue.offer(1); // O(1)
        queue.offer(2); // O(1)
        queue.offer(3); // O(1)
        queue.offer(4); // O(1)
        queue.offer(5); // O(1)

        System.out.println(queue.peek()); // O(1)

        System.out.println(queue.poll()); // O(1)
        System.out.println(queue.poll()); // O(1)
        System.out.println(queue.poll()); // O(1)
    }*/

    private static void queueDemo() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // O(1)
        queue.offer(2); // O(1)
        queue.offer(3); // O(1)
        queue.offer(4); // O(1)
        queue.offer(5); // O(1)

        System.out.println(queue.peek());
        System.out.println(queue.poll()); // O(1)
        System.out.println(queue.poll()); // O(1)
        System.out.println(queue.poll()); // O(1)

    }
}
