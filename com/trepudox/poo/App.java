package com.trepudox.poo;

public class App {

    public static void main(String[] args) {
        Oooo oooo = new Oooo() {
            @Override
            public void printOie() {
                System.out.println("Oie?");
            }

            @Override
            public String toString() {
                return "oooo";
            }
        };

        System.out.println(oooo.i);
        oooo.printOi();
        oooo.printOie();
    }

}
