package com.trepudox;

import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {
        Optional<Integer> emptyOptional = Optional.empty();
        Optional<Integer> optional = Optional.of(10);

        try {
            emptyOptional.orElseThrow(() -> new RuntimeException("ops"));
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println("peguei");
        }

        System.out.println(emptyOptional.orElse(10));
    }

}
