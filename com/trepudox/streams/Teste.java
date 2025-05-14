package com.trepudox.streams;

import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};

        print(Arrays.stream(array).sum());
        print(Arrays.toString(Arrays.stream(array).distinct().toArray()));
    }

    public static void print(Object o) {
        System.out.println(o);
    }

}
