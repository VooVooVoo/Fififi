package it.morfoza;

import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

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

            int result = number1a + number2a;

            Map<String, Object> model = new HashMap();
            model.put("result", result);
            model.put("number1", number1);
            model.put("number2", number2);
            return new ModelAndView(model, "result.ftl");
        }, new FreeMarkerEngine());

        Spark.get("/contact", (request, response) -> {
                    return "<html>" +
                            "<form action=\"/calculator\">" +
                            "<input name=\"number1\">" +
                            "<input name=\"number2\">" +
                            "<input type=\"submit\">" +
                            "</form>" +
                            "</html>";
        });
        Spark.get("/user", (request, response) -> {
            String name = request.queryParams("name");
            String surname = request.queryParams("surname");
            String userID = request.queryParams("userID");
            String password = request.queryParams("password");

            String name1 = String.valueOf(name);
            String surname1 = String.valueOf(surname);
            String userID1 = String.valueOf(userID);
            String password1 = String.valueOf(password);

            Map<String, Object> model = new HashMap();
            model.put("Name", name1);
            model.put("Surname", surname1);
            model.put("UserID", userID1);
            model.put("Password", password1);
            return new ModelAndView(model, "User.ftl");
        }, new FreeMarkerEngine());

        Spark.get("/user", (request, response) -> {
                return "<html>" +
                        "<form action=\"/user\">" +
                        "<input name=\"Name\">" +
                        "<input name=\"Surname\">" +
                        "<input name=\"User ID\">" +
                        "<input name=\"Password\">" +
                        "<input type=\"submit\">" +
                        "</form>" +
                        "</html>";
        });

    }
}
