package it.morfoza;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int result = 25600*25600;
        System.out.println("Hello! What's your name?");
        Scanner input = new Scanner (System.in);
        String name = input.nextLine();
        System.out.println(name + ", your result is : " + result);

    }
}
