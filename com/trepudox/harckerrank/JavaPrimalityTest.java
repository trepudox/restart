package com.trepudox.harckerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaPrimalityTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();

        bufferedReader.close();

        boolean isPrime = new BigInteger(n).isProbablePrime(99);

        if (isPrime)
            System.out.println("prime");
        else
            System.out.println("not prime");
    }

}
