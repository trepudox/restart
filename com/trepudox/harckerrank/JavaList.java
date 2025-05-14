package com.trepudox.harckerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int listLength = scanner.nextInt();
        scanner.nextLine();
        String listItems = scanner.nextLine();  // Verificar se passa ou precisa do nextLine
        int numberOfQueries = scanner.nextInt();

        List<Integer> l = new ArrayList<>(
                Arrays.stream(listItems.split(" ")).map(Integer::parseInt).collect(Collectors.toList())
        );

        for (int i = 0; i < numberOfQueries; i++) {
            String query = scanner.next();
            scanner.nextLine();

            if (query.equals("Insert")) {
                String insertInput = scanner.nextLine();
                List<Integer> insertItems = Arrays.stream(insertInput.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

                int insertIndex = insertItems.get(0);
                int insertValue = insertItems.get(1);

                l.add(insertIndex, insertValue);
            } else if (query.equals("Delete")) {
                int indexToDelete = Integer.parseInt(scanner.next());
                l.remove(indexToDelete);
            } else {
                System.out.println("????????????");
            }
        }

        scanner.close();

        l.forEach(e -> System.out.print(e + " "));
    }

}
