/*
Created by: Dany
Created on 06/01/2023 : 09:32
This is program build Pascal's Triangle
*/

public class PascalsTriangle {
    public static void main(String[] args) {
        int rows = 10; // number of rows

        for (int i = 0; i < rows; i++) {
            int number = 1;
            System.out.format("%" + (rows - i) * 2 + "s", ""); // print leading spaces

            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
