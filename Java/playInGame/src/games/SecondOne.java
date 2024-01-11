package playInGame.games;
/*
Created by: Dany
Created on 24/10/2022 : 11:36
This is program to
*/

import java.util.Random;
import java.util.Scanner;
import static playInGame.process.StartGame.EndMode;

public class SecondOne extends ThirdOne{
    public static void Start() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String description = "";
        System.out.println(description);

        System.out.println("Enter Stone (1) / Scissors (2) / Paper (2)");
        String userAnswer = scanner.nextLine();

        boolean userAnswerStone = false;
        boolean userAnswerScissors = false;
        boolean userAnswerPaper = false;

        if (userAnswer.contains("stone") || userAnswer.contains("1")) {
            userAnswerStone = true;
            userAnswer = "Stone";
        } else if (userAnswer.contains("scissors") || userAnswer.contains("2")) {
            userAnswerScissors = true;
            userAnswer = "Scissors";
        } else if (userAnswer.contains("paper") || userAnswer.contains("3")) {
            userAnswerPaper = true;
            userAnswer = "Paper";
        }

        int botAnswerRandom = random.nextInt(3);
        String botAnswer = "";

        boolean botAnswerStone = botAnswerRandom == 0;
        boolean botAnswerScissors = botAnswerRandom == 1;
        boolean botAnswerPaper = botAnswerRandom == 2;

        if (botAnswerStone) {
            botAnswer = "Stone";
        } else if (botAnswerScissors) {
            botAnswer = "Scissors";
        } else if (botAnswerPaper) {
            botAnswer = "Paper";
        }

        boolean winnerNobody = (userAnswerStone && botAnswerStone) || (userAnswerScissors && botAnswerScissors) || (userAnswerPaper && botAnswerPaper);
        boolean winnerUser = (userAnswerStone && botAnswerScissors) || (userAnswerScissors && botAnswerPaper) || (userAnswerPaper && botAnswerStone);
        boolean winnerBot = (botAnswerStone && userAnswerScissors) || (botAnswerScissors && userAnswerPaper) || (botAnswerPaper && userAnswerStone);

        if ((userAnswerStone == false) && (userAnswerScissors == false) && (userAnswerPaper == false)){
            EndMode(true);
        } else {
            System.out.println("\n\tResult:\n your\t\t mine\n" + userAnswer + "\t\t" + botAnswer + "\nWinner: " + (winnerNobody ? "Nobody" : winnerUser ? "You won" : winnerBot ? "I won" : ""));
        }
    }
}
