/*
Created by: Dany
Created on 17/10/2022 : 11:55
This is program to do Lorem Ipsum into ASCII
*/

public class LoremIpsum {

//LOREM IPSUM
    public static void loremIpsum() {
        String loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        for (int i = 0; i < "Lorem Ipsum".length(); i++) {
            System.out.print((int) "Lorem Ipsum".charAt(i));
        }
        System.out.println("\n\tLorem Ipsum\n");

        for (int i = 0; i < loremIpsum.length(); i++) {
            //System.out.println(loremIpsum.charAt(i));
            System.out.print((int) loremIpsum.charAt(i) + " ");
        }

        /*
        String LI = String.valueOf(((char) 0));
        LI += ((char) 'L');
        LI += ((char) 'o');
        LI += ((char) 'r');
        LI += ((char) 'e');
        LI += ((char) 'm');

        //int outLI = (int)LI;
        //System.out.println((int)LI);
        */
    }
}
