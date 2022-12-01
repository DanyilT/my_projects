package PlayInGame.src.process;
/*
Created by: Dany
Created on 21/11/2022 : 12:56
This is program to
*/

import java.util.Scanner;

public class Process extends Find {

    public static String process(String message) {
        Scanner scanner = new Scanner(System.in);

        int selectedNumOfGame = find(message, numOfGame);

        if (selectedNumOfGame < 0) {
            System.out.println("I did not find the number of the game you want to play😔");
        } else {
            int startGame = StartGame(selectedNumOfGame);
        }
        return "See you!👋";
    }
}
