package com.trepudox.tipos;

import java.util.Arrays;

public class Strings {

    public static void main(String[] args) {
        String string = "Hello world!";

        System.out.println("Original: " + string);
        System.out.println("toUpperCase(): " + string.toUpperCase());
        System.out.println("toLowerCase(): " + string.toLowerCase());
        System.out.println("split(\" \"): " + Arrays.deepToString(string.split(" ")));
        System.out.println("toLowerCase(): " + string.toLowerCase());

    }

}
