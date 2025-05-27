package com.trepudox.collections.misc;

import java.util.*;

public class TestQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);

        System.out.printf("Óia o peek: %d%n", queue.peek());
        System.out.printf("Ops dei um poll aq: %d%n", queue.poll());
        System.out.printf("Óia o peek dnv kkk: %d%n", queue.peek());

        for (int i : queue) {
            System.out.printf("Ó o FIFO aí: %d%n", i);
        }
    }

}
