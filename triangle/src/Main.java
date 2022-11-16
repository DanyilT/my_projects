/*
Created by: Dany
Created on  : 14:32
This is program to
*/

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("_________________________");
        System.out.println(">>describe the triangle<<");

        System.out.printf("\nEnter the side a > ");
        double a = scanner.nextDouble();
        System.out.printf("Enter the side b > ");
        double b = scanner.nextDouble();
        System.out.printf("Enter the side c > ");
        double c = scanner.nextDouble();

        /*boolean A = (a+b > c) ? true : false;
        boolean B = (a+c > b) ? true : false;
        boolean C = (b+c > a) ? true : false;
        System.out.println(A && B && C ? "It is real a triangle" : "it is not real a triangle");*/

        boolean equilateral_triangle = (a == b && b == c && c == a) ? true : false;
        boolean isosceles_triangle = (a == b) ? true : (b == c) ? true : (c == a) ? true : false;

        double perimeter = a + b + c;
        double semi_perimeter = perimeter / 2;
        double area = Math.sqrt(semi_perimeter * (semi_perimeter - a) * (semi_perimeter - b) * (semi_perimeter - c));

        if (area <= 0) {
            System.out.println("\nIT IS NOT A TRIANGLE");
        }else {
            System.out.println("________________________");
            System.out.println("Its a " + (equilateral_triangle ? "equilateral triangle" : isosceles_triangle ? "isosceles triangle" : "arbitrary triangle"));
            System.out.println("________________");
            System.out.println("Perimeter = " + perimeter);
            System.out.println("______________");
            System.out.println("Area = " + area);
        }
    }
}
