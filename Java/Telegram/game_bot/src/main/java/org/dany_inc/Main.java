package org.dany_inc;
/*
Created by: Dany
Created on 21/11/2022 : 11:46
This is program to
*/

import java.util.Scanner;

import static org.dany_inc.process.Hello.sayHello;
import static org.dany_inc.process.NumOfGame.initNumOfGame;
import static org.dany_inc.process.Process.process;

public abstract class Main extends Process {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What game do you want to play?\n\t[first | second | third]\n");
        String message = scanner.nextLine();

        initNumOfGame();

        String botHello = sayHello(message);
        System.out.println(botHello);

        String botAnswer = process(message);
        System.out.println(botAnswer);
    }
}
