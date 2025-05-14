package com.trepudox.java17plus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PatternMatching {

    public static void main(String[] args) {
        Object o = randomReturn();
        System.out.println("Object: " + o);

        if (o instanceof String str) {
            System.out.println(str.toUpperCase());
        } else if (o instanceof Long l) {
            System.out.println(Long.MAX_VALUE - l);
        } else if (o instanceof Integer i) {
            System.out.println(i * 2);
        } else if (o instanceof Double d) {
            System.out.printf("%.3f", d);
        }
    }

    public static Object randomReturn() {
        List<Object> lista = new ArrayList<>();
        lista.add("oieeee");
        lista.add(10);
        lista.add(10000L);
        lista.add(9.9);

        Collections.shuffle(lista);

        return lista.getFirst();
    }

}
