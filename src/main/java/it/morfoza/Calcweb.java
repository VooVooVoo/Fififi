package it.morfoza;

import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

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
        Spark.staticFileLocation("/webfiles");

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

            int result = Calculator.calculate(number1a, number2a);

            Map<String, Object> model = new HashMap();
            model.put("result", result);
            model.put("number1", number1);
            model.put("number2", number2);
            return new ModelAndView(model, "result.ftl");
        }, new FreeMarkerEngine());


        Spark.get("/form", (request, response) -> {
            return new ModelAndView(null, "User.ftl");
        }, new FreeMarkerEngine());

        Spark.get("/user", (request, response) -> {
            String name = request.queryParams("name");
            String surname = request.queryParams("surname");
            String id = request.queryParams("id");
            String password = request.queryParams("password");


            Map<String, Object> model = new HashMap();
            model.put("name", name);
            model.put("surname", surname);
            model.put("id", id);
            model.put("password", password);
            return new ModelAndView(model, "User.ftl");
        }, new FreeMarkerEngine());

    }
}
