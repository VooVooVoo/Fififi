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

        Spark.get("/calc", (request, response) -> {
            return "<html> Hello <b> Buddy </b> </html>";
        });


        Spark.get("/contact", (request, response) -> {
                return "<html> " +
                        "<form action=\"/calculator\">" +
                        "<input name=\"number1\">" +
                        "<input name=\"number2\">" +
                        "<input type=\"submit\">" +
                        "</form>" +
                        "</html>";
        });

    }
}
