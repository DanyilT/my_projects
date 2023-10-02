/*
Created by: Dany
Created on 17/10/2022 : 12:22
This is program to
*/

import java.util.Scanner;

public class InputChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        char letter = 0;

        char stop = 126;

        while (letter == stop){
            input = scanner.nextLine();
            letter = input.charAt(0);
            System.out.println("Letter entered was " + (int)letter);
        }

        /*for (char i = 0; i == stop; i++) {
            input = scanner.nextLine();
            letter = input.charAt(0);
            System.out.println("Letter entered was " + (int)letter);
        }*/

    }
}
