package it.morfoza;

/**
 * Created by Wojt on 2016-08-09.
 */
public class CalculatorMain {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("text")) {
            CalculatorConsole.runOnConsole(args);
        } else {
            CalculatorSpringBoot.runOnSpring(args);
        }
    }
}
