/*
Created by: Dany
Created on 14/12/2022 : 14:40
This is program to do ASCII into Text
*/

import java.util.Scanner;

public class TextByASCII {
    static Scanner scanner = new Scanner(System.in);

//TEXT BY ASCII
    public static void textByASCII() {
        System.out.println("\tASCII to Text");
        System.out.println("\n||Enter ASCII:");

        String ascii = scanner.nextLine();
        String[] args = {String.valueOf(ascii.length())};

        for (String asciiCode : args) {
            // Convert the ASCII code to a character
            char decodedChar = (char) Integer.parseInt(asciiCode);

            // Print the decoded character
            System.out.println(decodedChar);
        }
    }
}
