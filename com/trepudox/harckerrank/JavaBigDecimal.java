package com.trepudox.harckerrank;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JavaBigDecimal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.next());
        }

        Comparator<String> customComparator = (o1, o2) -> {
            BigDecimal b1 = new BigDecimal(o1.toCharArray(), new MathContext(1000, RoundingMode.UNNECESSARY));
            BigDecimal b2 = new BigDecimal(o2.toCharArray(), new MathContext(1000, RoundingMode.UNNECESSARY));
            return b2.compareTo(b1);
        };

        list.sort(customComparator);
        list.forEach(System.out::println);
    }

    /////// [1, 3, 2, 0.1, .1, -1, 5]
    /////// [5, 3, 2, 1, 0.1, .1, -1]

}
