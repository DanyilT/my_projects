/*
Created by: Dany
Created on 14/12/2022 : 11:59
This is program to do Table into ASCII
*/

import java.util.Scanner;

public class Table {

//SYMBOLS
    public static void symbols() {
        System.out.println("\t_____________________\n\t|\t\tSymbols\t\t|");
        for (int i = 32; i <= 47; i++) {
            System.out.println("~ " + i + " |> " + (char) i);
        }
        for (int i = 58; i <= 64; i++) {
            System.out.println("~ " + i + " |> " + (char) i);
        }
        for (int i = 91; i <= 96; i++) {
            System.out.println("~ " + i + " |> " + (char) i);
        }
        for (int i = 123; i <= 126; i++) {
            System.out.println("~ " + i + " |> " + (char) i);
        }
    }

//NUMBERS
    public static void numbers() {
        System.out.println("\t_____________________\n\t|\t\tNumbers\t\t|");
        for (int i = 48; i <= 57; i++) {
            System.out.println("~ " + i + " |> " + (char) i);
        }
    }

//CAPITAL LETTERS
    public static void capitalLetters() {
        System.out.println("\t_____________________\n\t|\tCapital Letter\t|");
        for (int i = 58; i <= 64; i++) {
            System.out.println("~ " + i + " |> " + (char) i);
        }
    }

//LOW LETTERS
    public static void lowLetters() {
        System.out.println("\t_____________________\n\t|\tLow Letter\t\t|");
        for (int i = 97; i <= 122; i++) {
            System.out.println("~ " + i + " |> " + (char) i);
        }
    }
}
