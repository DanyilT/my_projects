package PlayInGame;
/*
Created by: Dany
Created on 24/10/2022 : 13:07
This is program to
*/

import java.util.Random;
import java.util.Scanner;

public class GameSelection {

    private static void chose(String message) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final String first = "first", second = "second", third = "third";

        System.out.println("What game do you want to play?\t(first | second | third)");

        message = scanner.nextLine().toLowerCase();

        boolean notFirst = message != first;
        boolean notSecond = message != second;
        boolean notThird = message != third;

        boolean toRepeat = notFirst && notSecond && notThird;

        while (toRepeat) {


            notFirst = message != first;
            notSecond = message != second;
            notThird = message != third;

            toRepeat = notFirst && notSecond && notThird;

            System.out.println("Sorry, I'm not understand\nPlease, try again\t(just enter: first | second | third)");
            message = scanner.nextLine().toLowerCase();

        }


        if (notFirst == false) {
            System.out.println("OK, first");
        } else {
            notFirst = true;
        }
        if (notSecond == false) {
            System.out.println("OK, second");
        } else {
            notSecond = true;
        }
        if (notThird == true) {
            System.out.println("OK, third");
        } else {
            notThird = true;
        }


        /*int firstonerandomnumberneedtoguess = random.nextInt(0, 10),
                secondonerandomnumberneedtoguess = random.nextInt(0, 10),
                thirdonerandomnumberneedtoguess = random.nextInt(0, 10);
        int firstonerandomnumberneedtoenter = scanner.nextInt(),
                secondonerandomnumberneedtoenter = scanner.nextInt(),
                thirdonerandomnumberneedtoenter = scanner.nextInt();*/
    }
}
