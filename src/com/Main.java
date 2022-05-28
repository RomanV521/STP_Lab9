package com;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        JSONGetter jsonGetter = new JSONGetter();
        JSONGetter jsonGetter1 = new JSONGetter();
        JSONGetter.url = "https://community-open-weather-map.p.rapidapi.com/weather?q=London%2Cuk";
        jsonGetter.start();
//        jsonGetter1.start();


        jsonGetter.join();

        System.out.println("Waining for data...");
        String jsonString = jsonGetter.getOutJson();
        System.out.println(jsonString);

        Object obj = null;
        try {
            obj = new JSONParser().parse(jsonString);
            System.out.println(obj);
        } catch (ParseException e){
            e.printStackTrace();
        }
        System.out.println();

//        JSONArray jsonArray = (JSONArray) obj;
//        System.out.println(jsonArray.toJSONString());
//        System.out.println();
    }
}
