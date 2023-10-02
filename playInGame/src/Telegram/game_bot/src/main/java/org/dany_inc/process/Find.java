package org.dany_inc.process;
/*
Created by: Dany
Created on 21/11/2022 : 12:07
This is program to
*/

import java.util.Map;

public class Find extends NumOfGame {
    public static int find(String message, Map<String, Integer> data) {
        message = message.toLowerCase();

        for (String word : data.keySet()) {
            if (message.contains(word)) {
                return data.get(word);
            }
        }
        return -1;
    }
}