package org.dany_inc.games;
/*
Created by: Dany
Created on 24/10/2022 : 11:36
This is program to
*/

import java.util.Random;
import java.util.Scanner;

import static org.dany_inc.process.StartGame.EndMode;

public class FirstOne extends SecondOne{
    public static void Start() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String description = "";
        System.out.println(description);

        System.out.println("Enter three numbers\n\t(from 1 to 9)");
        int userAnswer1 = scanner.nextInt(), userAnswer2 = scanner.nextInt(), userAnswer3 = scanner.nextInt();
        int botAnswer1 = random.nextInt(10);
        if (botAnswer1 == 0) {
            botAnswer1++;
        }
        int botAnswer2 = random.nextInt(10);
        int botAnswer3 = random.nextInt(10);
        while ((botAnswer2 == botAnswer1) || (botAnswer2 ==0)) {
            botAnswer2 = random.nextInt(10);
        }
        while (((botAnswer3 == botAnswer1) || (botAnswer3 == botAnswer2)) || (botAnswer2 ==0)) {
            botAnswer3 = random.nextInt(10);
        }
        boolean answer1_HighLevel = botAnswer1 == userAnswer1, answer2_HighLevel = botAnswer2 == userAnswer2, answer3_HighLevel = botAnswer3 == userAnswer3;
        boolean perfect_HighLevel = answer1_HighLevel && answer2_HighLevel && answer3_HighLevel, good_HighLevel = (answer1_HighLevel && answer2_HighLevel) || (answer2_HighLevel &&answer3_HighLevel) || (answer1_HighLevel && answer3_HighLevel), ok_HighLevel = answer1_HighLevel || answer2_HighLevel ||answer3_HighLevel;

        boolean answer1_LowLevel = (botAnswer1 == userAnswer1),
                answer2_LowLevel = (botAnswer2 == userAnswer2),
                answer3_LowLevel = (botAnswer3 == userAnswer3),
                answer4_LowLevel = (botAnswer1 == userAnswer2),
                answer5_LowLevel = (botAnswer1 == userAnswer3),
                answer6_LowLevel = (botAnswer2 == userAnswer1),
                answer7_LowLevel = (botAnswer2 == userAnswer3),
                answer8_LowLevel = (botAnswer3 == userAnswer1),
                answer9_LowLevel = (botAnswer3 == userAnswer2);
        boolean perfect_LowLevel = (answer1_LowLevel || answer4_LowLevel || answer5_LowLevel) && (answer2_LowLevel || answer6_LowLevel || answer7_LowLevel) && (answer3_LowLevel || answer8_LowLevel || answer9_LowLevel),
                good_LowLevel = ((answer1_LowLevel || answer4_LowLevel || answer5_LowLevel) && (answer2_LowLevel || answer6_LowLevel || answer7_LowLevel)) || ((answer1_LowLevel || answer4_LowLevel || answer5_LowLevel) && (answer3_LowLevel || answer8_LowLevel || answer9_LowLevel)) || ((answer2_LowLevel || answer6_LowLevel || answer7_LowLevel) && (answer3_LowLevel || answer8_LowLevel || answer9_LowLevel)),
                ok_LowLevel = answer1_LowLevel || answer2_LowLevel || answer3_LowLevel || answer4_LowLevel || answer5_LowLevel || answer6_LowLevel || answer7_LowLevel || answer8_LowLevel || answer9_LowLevel;
        if (userAnswer1 < 1 || userAnswer2 < 1 || userAnswer3 < 1 ||
                userAnswer1 > 9 || userAnswer2 > 9 || userAnswer3 > 9) {
            EndMode(true);
        } else {
            System.out.println("Yours: " + userAnswer1 + " | " + userAnswer2 + " | " + userAnswer3 +
                    "\nMine:  " + botAnswer1 + " | " + botAnswer2 + " | " + botAnswer3);
            if (((perfect_HighLevel) || (good_HighLevel) || (ok_HighLevel)) && ((perfect_LowLevel) || (good_LowLevel) || (ok_LowLevel))) {
                System.out.println(perfect_HighLevel ? "Well done [correct sequence]\n\t(3/3) <the probability of this event = 2.7%\nAre you cheating?😧>" : good_HighLevel ? "Good job [correct sequence]\n\t(2/3) <the probability of this event = 5.5%>\nAre you cheating?😎" : (((ok_HighLevel) && (good_LowLevel)) && ((answer1_LowLevel == false) && (answer2_LowLevel == false) && (answer3_LowLevel == false))) ?  "Not bad [correct sequence]\n\t(1/3) <the probability of this event = 11.1%>\nand [not correct sequence]\n\t(2/3) <the probability of this event = 16.6%>" : (((ok_HighLevel) && (ok_LowLevel)) && ((answer1_LowLevel == false) && (answer2_LowLevel == false) && (answer3_LowLevel == false))) ? "Not bad [correct sequence]\n\t(1/3) <the probability of this event = 11.1%>\nand [not correct sequence]\n\t(1/3) <the probability of this event = 33.3%>" : "You lose");
            } else {
                //_HighLevel
                if ((perfect_HighLevel) || (good_HighLevel) || (ok_HighLevel)) {
                    System.out.println(perfect_HighLevel ? "Well done [correct sequence]\n\t(3/3) <the probability of this event = 2.7%>\nAre you cheating?😧" : good_HighLevel ? "Good job [correct sequence]\n\t(2/3) <the probability of this event = 5.5%>\nAre you cheating?😎" : ok_HighLevel ? "Not bad [correct sequence]\n\t(1/3) <the probability of this event = 11.1%>" : "You lose");
                }
                //_LowLevel
                if ((perfect_LowLevel) || (good_LowLevel) || (ok_LowLevel)) {
                    System.out.println(perfect_LowLevel ? "Well done [not correct sequence]\n\t(3/3) <the probability of this event = 8.3%>" : good_LowLevel ? "Good job [not correct sequence]\n\t(2/3) <the probability of this event = 16.6%>" : ok_LowLevel ? "Not bad [not correct sequence]\n\t(1/3) <the probability of this event = 33.3%>" : "You lose\n\t(0/3) <the probability of this event = 66.7%>");
                }
                //_Lose
                else {
                    System.out.println("You lose\n\t(0/3) <the probability of this event = 66.7%>");
                }
            }
        }
    }
}
