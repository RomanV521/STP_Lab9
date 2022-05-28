package com;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Currency;

/**
 * Vykhodets Roman, #1
 */
public class Main {

    private static void Start() {
        System.out.println("\nCompleted by student AT-212 \nOdessa Polytechnic University \nVykhodets Roman \n\nVariant 1 \n\n");
    }

    public static void main(String[] args) throws InterruptedException {
        Start();

        JSONGetter jsonGetter = new JSONGetter();
//        JSONGetter.url = "https://community-open-weather-map.p.rapidapi.com/weather?q=London%2Cuk";
        JSONGetter.url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        jsonGetter.start();

        jsonGetter.join();

//        System.out.println("Waining for data...");
        String jsonString = jsonGetter.getOutJson();
//        System.out.println(jsonString);

        Object obj = null;
        try {
            obj = new JSONParser().parse(jsonString);
//            System.out.println(obj);
        } catch (ParseException e){
            e.printStackTrace();
        }

        JSONArray jsonArray = (JSONArray) obj;
//        System.out.println(jsonArray.toJSONString());
//        System.out.println();

        Cars cars = new Cars();

        for (Object jsonObject : jsonArray){
            JSONObject current = (JSONObject) jsonObject;
            String name = (String) current.get("nome");
            String codding = (String) current.get("codigo");

            Car car = new Car(name, codding);
            cars.add(car);
        }

        System.out.println(cars);

        cars.getCars().sort(Car.byNameAsc);
        System.out.println("Format by name (ascending)\n"+cars);
        cars.getCars().sort(Car.byNameDesc);
        System.out.println("Format by name (descending)\n"+cars);

        cars.getCars().sort(Car.byCodingAsc);
        System.out.println("Format by coding (ascending)\n"+cars);
        cars.getCars().sort(Car.byCodingDesc);
        System.out.println("Format by coding (descending)\n"+cars);
    }
}
