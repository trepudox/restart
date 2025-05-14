package com.trepudox.harckerrank;

import java.util.Scanner;
import java.util.function.IntPredicate;

public class JavaLambdaExpressions {

    public static void main(String[] args) {
        IntPredicate isOdd = x -> x % 2 == 1;

        IntPredicate isPrime = x -> {
            int aux = 0;
            for (int i = 1; i < x; i++) {
                if (x % i == 0) {
                    aux += 1;
                }
            }

            return aux <= 2;
        };

        IntPredicate isPalindrome = x -> {
            String s = String.valueOf(x);

            String firstPart, secondPart;
            if (s.length() % 2 == 0) {
                firstPart = s.substring(0, (s.length() / 2) - 1);
                secondPart = s.substring(s.length() / 2);
            } else {
                firstPart = s.substring(0, s.length() / 2);
                secondPart = s.substring((s.length() / 2) + 1);
            }

            String reversedSecondPart = new StringBuilder(secondPart).reverse().toString();
            return firstPart.equals(reversedSecondPart);
        };

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] splittedInput = input.split(" ");

            int caseNumber = Integer.parseInt(splittedInput[0]);
            int caseValue = Integer.parseInt(splittedInput[1]);

            switch (caseNumber) {
                case 1:
                    if (isOdd.test(caseValue)) {
                        System.out.println("ODD");
                    } else {
                        System.out.println("EVEN");
                    }
                    break;
                case 2:
                    if (isPrime.test(caseValue)) {
                        System.out.println("PRIME");
                    } else {
                        System.out.println("COMPOSITE");
                    }
                    break;
                case 3:
                    if (isPalindrome.test(caseValue)) {
                        System.out.println("PALINDROME");
                    } else {
                        System.out.println("NOT PALINDROME");
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
