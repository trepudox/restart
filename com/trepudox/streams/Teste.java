package com.trepudox.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Teste {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 3, 3, 3, 4, 5, 6, 7, 7);
        List<List<Integer>> integerListsList = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));

        print("integerList: " + integerList);
        print("integerListsList: " + integerListsList);
        print("");

        reduce(integerList);

        distinct(integerList);

        filter(integerList);

        map(integerList);

        flatMap(integerListsList);

        mapAndFlatMap(integerListsList);

        allMatch(integerList);
    }

    public static void reduce(List<Integer> integerList) {
        print("reduce(integerList) - " +
                integerList.stream()
                        .reduce(Integer::sum)
                        .orElse(0));
    }

    public static void distinct(List<Integer> integerList) {
        print("distinct(integerList) - " +
                integerList.stream()
                        .distinct()
                        .toList());
    }

    public static void filter(List<Integer> integerList) {
        print("filter(integerList) - " +
                integerList.stream()
                        .filter(n -> n % 2 == 0)
                        .toList());
    }

    public static void map(List<Integer> integerList) {
        // ! No map(), cada elemento será transformado em um outro elemento, podendo ser do mesmo tipo ou não.
        // ! É uma transformação "one-to-one"

        print("map(integerList) - " +
                integerList.stream()
                        .map(i -> i + "string")
                        .toList()
        );
    }

    public static void flatMap(List<List<Integer>> integerListsList) {
        // ! No flatMap(), cada elemento será transformado em "zero" ou mais elementos de uma nova stream.
        // ! Pode ser "one-to-zero", "one-to-one" ou "one-to-many", depende dos elementos e da lógica aplciada.
        // ! https://medium.com/@reetesh043/java-stream-map-vs-flatmap-60a10e666c75

        print("flatMap(integerListsList) - " +
                integerListsList.stream()
                        .flatMap(Collection::stream)
                        .toList());
    }

    public static void mapAndFlatMap(List<List<Integer>> integerListsList) {
        print("mapAndFlatMap(integerListsList) - " +
                integerListsList.stream()
                        .map(l -> {
                            List<Integer> newList = new ArrayList<>(l);
                            newList.add(0);
                            return newList;
                        })
                        .flatMap(Collection::stream)
                        .toList());
    }

    public static void allMatch(List<Integer> integerList) {
        print("allMatch(integerList) - " +
                integerList.stream()
                        .allMatch(Objects::nonNull)
        );
    }

    public static void print(Object o) {
        System.out.println(o);
    }

}
