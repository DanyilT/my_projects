/*
Created by: Dany
Created on 06/01/2023 : 11:11
This is program write Fibonacci Sequence
*/

import java.util.Scanner;

public class FibonacciSequence {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("Lenght of Sequence (int only)  #");
        int n = scanner.nextInt(); // number of Fibonacci numbers to generate
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + " ");
        }
    }
}
