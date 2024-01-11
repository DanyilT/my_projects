/*
Created by: Dany
Created on  : 10:20
This is program to
*/

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter an integer");
        int a = scanner.nextInt();

        for (int i = a; i > 100000;) {
            System.out.println("Too large a number" + "\nplease write a shorter number");
            a = scanner.nextInt();
        }
        if (a<100000) {
            int a1 = a/100;
            int a2 = a/10%10;
            int a3 = a%10;
            System.out.println("Число едениц в нём = " + a3);
            System.out.println("Число десятков в нём = " + a2);
            System.out.println("Сумма его цифр = " + (a1+a2+a3));
            System.out.println("Произведение его цифр = " + (a1*a2*a3));
        }else {
        }
        System.in
        System.err
        System.out.
    }
}
