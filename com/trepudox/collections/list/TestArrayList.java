package com.trepudox.collections.list;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
        List<Integer> list = getList();

        System.out.println(list.getFirst());
        list.addFirst(-1);
        System.out.println(list.getFirst());


        System.out.println(list.getLast());
        list.add(-2);
        System.out.println(list.getLast());
    }

    private static List<Integer> getList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        return list;
    }

}
