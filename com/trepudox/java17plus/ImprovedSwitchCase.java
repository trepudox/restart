package com.trepudox.java17plus;

import java.util.Scanner;

public class ImprovedSwitchCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input -> ");
        String input = scanner.next();

        String retorno1 = oldSwitchCase(input);
        String retorno2 = improvedSwitchCase(input);

        System.out.printf("Retorno oldSwitchCase: %s%n", retorno1);
        System.out.printf("Retorno improvedSwitchCase: %s%n", retorno2);
    }

    private static String oldSwitchCase(String input) {
        String retorno;
        
        switch (input) {
            case "oi":
                retorno = "oi, oi";
                break;
            case "oie":
                retorno = "oiee";
                break;
            case "hmmm":
                retorno = "hmmmmmmmm";
                break;
            default:
                retorno = "tem nada aq n man";
                break;
        }

        return retorno;
    }

    private static String improvedSwitchCase(String input) {
        return switch (input) {
            case "oi" -> "oi, oi";
            case "oie" -> "oiee";
            case "hmmm" -> "hmmmmmmmm";
            default -> "tem nada aq n man";
        };
    }
    
}
