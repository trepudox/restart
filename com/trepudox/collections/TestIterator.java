package com.trepudox.collections;

import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        Iterator<Integer> iterator = getIterator();

        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.printf("Aqui ó to dentro do loop, ó o valor: %d%n", i);

            if (i == 5) {
                break;
            }
        }

        iterator.forEachRemaining(i -> System.out.printf("Saí do loop kkkk, ó o valor ae: %d%n", i));
    }

    private static Iterator<Integer> getIterator() {
        return List.of(1, 2, 3, 4, 5, 6, 7, 8).iterator();
    }

}
