package it.morfoza;

import spark.Spark;

/**
 * Created by Wojt on 2016-07-25.
 */
public class Calcweb {

    public static void main(String[] args) {
        String port = System.getenv("PORT");
        if (port !=null) {
            int portInt = Integer.parseInt(port);
            Spark.port(portInt);
        }

        Spark.get("/hello", (request, response) -> {
            return "<html> Hello <b> Buddy </b> <br/>" +
                    "Now you can do things!" +
                    "</html>";
        });


        Spark.get("/calculator", (request, response) -> {
            String number1 = request.queryParams("number1");
            String number2 = request.queryParams("number2");

            int number1a = Integer.parseInt(number1);
            int number2a = Integer.parseInt(number2);

            int results = number1a + number2a

            return "<html>Hi, <b> buddy </b>! Your numbers:"
                        + number1 +
                        ", "
                        + number2 +
                        "</html>";});

        Spark.get("/contact", (request, response) -> {
            return "<html>" +
                        "<form action=\"/calculator\">" +
                        "<input name=\"number1\">" +
                        "<input name=\"number2\">" +
                        "<input type=\"submit\">" +
                        "</form>" +
                        "</html>";
        });

    }
}
