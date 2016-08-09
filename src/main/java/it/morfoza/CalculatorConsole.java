package it.morfoza;

import java.util.Scanner;

public class CalculatorConsole {

    public static void runOnConsole(String[] args) {
	// write your code here
        System.out.println("Do you want to:");
        System.out.println("1.Add");
        System.out.println("2.Subtract");
        System.out.println("3.Multiply");
        System.out.println("4.Divide");
        System.out.println("5.Have sex");
        Scanner input = new Scanner (System.in);
        String name = input.nextLine();

        if (name.equals("5")) {
            System.out.println("Let's do this!");
        }
else {
            System.out.println("How much is x:");
            int x = input.nextInt();
            System.out.println("How much is y:");
            int y = input.nextInt();

            if (name.equals("1")) {
                int result = x + y;
                System.out.println("Your result of adding " + x + " to " + y + " is : " + result);
            }
            if (name.equals("2")) {
                int result = x - y;
                System.out.println("Your result of substracting " + x + " from " + y + " is : " + result);
            }
            if (name.equals("3")) {
                int result = x * y;
                System.out.println("Your result of multiplying " + x + " by " + y + " is : " + result);
            }
            if (name.equals("4")) {
                int result = x / y;
                System.out.println("Your result of dividing " + x + " by " + y + " is : " + result);
            }

        }

    }
}



