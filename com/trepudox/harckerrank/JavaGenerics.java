package com.trepudox.harckerrank;

public class JavaGenerics {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"Hello", "World"};

        printArray(intArray);
        printArray(strArray);
    }

    @SafeVarargs
    public static <T> void printArray(T... array) {
        for (Object o : array) {
            System.out.println(o);
        }
    }

}
