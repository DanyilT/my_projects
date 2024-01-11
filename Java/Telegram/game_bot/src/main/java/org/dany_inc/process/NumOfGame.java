package org.dany_inc.process;
/*
Created by: Dany
Created on 21/11/2022 : 12:47
This is program to
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class NumOfGame extends Hello {
    public static Map<String, Integer> numOfGame;
    public static void initNumOfGame() {

        final String first = "first", second = "second", third = "third";

        numOfGame = new LinkedHashMap<>();

        numOfGame.put(first, 1);
        numOfGame.put("1", 1);
        numOfGame.put(second, 2);
        numOfGame.put("2", 2);
        numOfGame.put(third, 3);
        numOfGame.put("3", 3);
    }
}
