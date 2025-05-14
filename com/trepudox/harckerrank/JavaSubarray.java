package com.trepudox.harckerrank;

import java.util.Scanner;

public class JavaSubarray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int negativeSubarrays = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int sum = 0;

                for (int k = j; k <= i; k++) {
                    sum += arr[k];
                }

                if (sum < 0) {
                    negativeSubarrays++;
                }
            }
        }

        System.out.println(negativeSubarrays);
    }

}
