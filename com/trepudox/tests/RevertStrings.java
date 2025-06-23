package com.trepudox.tests;

public class RevertStrings {

    public static void main(String[] args) {
        String helloWorld = "Hello World!";
        String abc = "abcdefgh";

        revertStrings1(helloWorld);
        revertStrings1(abc);

        revertStrings2(helloWorld);
        revertStrings2(abc);
    }

    public static void revertStrings1(String s) {
        System.out.println(new StringBuilder(s).reverse());
    }

    public static void revertStrings2(String s) {
        char[] originalCharArray = s.toCharArray();
        char[] newCharArray = new char[s.length()];

        for (int i = originalCharArray.length - 1, j = 0; i >= 0 && j < originalCharArray.length; i--, j++) {
            newCharArray[j] = originalCharArray[i];
        }

        System.out.println(new String(newCharArray));
    }
}
