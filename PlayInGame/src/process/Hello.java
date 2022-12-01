package PlayInGame.src.process;
/*
Created by: Dany
Created on 21/11/2022 : 12:46
This is program to
*/

import java.util.Random;

public class Hello extends StartGame{
    public static boolean isHelloMessage(String message) {

        message = message.toLowerCase();

        String hello1 = "hello", hello2 = "hi";

        return message.contains(hello1) || message.contains(hello2);
    }

    public static String sayHello(String message) {
        Random random = new Random();

        if (isHelloMessage(message)) {
            int randomHello = random.nextInt(2);
            String nameOfBot = "GameBot_[Dany.inc]";

            String helloAnswer1 = "Hello", helloAnswer2 = "Hi", helloAnswer3 = "Доброго вечора, ми з України";

                switch (randomHello) {
                    case 1:
                        return helloAnswer1 + " \n\tI - " + nameOfBot;
                    case 2:
                        return helloAnswer2 + " \n\tI - " + nameOfBot;
                    case 0:
                        return helloAnswer3 + " \n\tI - " + nameOfBot;
                }
        }
        return "";
    }
}
