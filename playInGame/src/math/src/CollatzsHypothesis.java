/*
Created by: Dany
Created on 06/01/2023 : 13:29
This is program to
*/

public class CollatzsHypothesis {
    public static void main(String[] args) {
        int n = 3; // number to test

        while (n != 1) {
            System.out.println(n);

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        System.out.println(n);
    }
}
