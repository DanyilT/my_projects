/*
Created by: Dany
Created on 14/12/2022 : 14:24
This is program to do Text into ASCII
*/

import java.util.Scanner;

public class TextToASCII {
    static Scanner scanner = new Scanner(System.in);

//TEXT TO ASCII
    public static void textToASCII() {
        System.out.println("\tText to ASCII");
        System.out.println("\n||Enter text:");
        String input = scanner.nextLine();
        String text = input;
        String textInASCII = "";

        for (int i = 0; i < text.length(); i++) {
            textInASCII = textInASCII + (char) input.charAt(i) + " ";
        }
        System.out.println("\n||ASCII:\n" + textInASCII);
    }
}
