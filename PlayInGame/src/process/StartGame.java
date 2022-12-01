package PlayInGame.src.process;
/*
Created by: Dany
Created on 21/11/2022 : 17:51
This is program to
*/

import PlayInGame.src.games.FirstOne;
import PlayInGame.src.games.SecondOne;

public class StartGame extends FirstOne {
    public static boolean EndMode(boolean stop) {
        if (stop) {
            System.err.println("wtf😡");
        }
        return stop;
    }

    public static int StartGame(int selectNumOfGame) {
        System.out.println("\n\t-------> Game #" + selectNumOfGame);
        switch (selectNumOfGame) {
            case 1:
                FirstOne.Start();
                break;
            case 2:
                System.out.println("Stone / Scissors / Paper");
                SecondOne.Start();
                break;
            case 3:
                System.out.println("Coming soon");
                //ThirdOne.Start();
                break;
        }
        return selectNumOfGame;
    }
}
