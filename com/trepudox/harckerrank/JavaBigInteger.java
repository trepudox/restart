package com.trepudox.harckerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String n1 = scanner.next();

        String n2 = scanner.next();

        scanner.close();

        BigInteger big1 = new BigInteger(n1);
        BigInteger big2 = new BigInteger(n2);

        System.out.println(big1.add(big2));
        System.out.println(big1.multiply(big2));
    }

}
