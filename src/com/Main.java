package com;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

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
        cars.getCars().ensureCapacity(100);

        for (Object jsonObject : jsonArray){
            JSONObject current = (JSONObject) jsonObject;
            String name = (String) current.get("nome");
            String codding = (String) current.get("codigo");

            Car car = new Car(name, codding);
            cars.add(car);
//            cars1.add(car);
        }
//        Cars cars1 = new Cars();
        List<Car> cars2 = new ArrayList<Car>(cars.getCars());
//        //1
////        cars1.getCars().addAll(0,cars.getCars());
////        cars1.remove(0);
//
//        cars.add(new Car("fdsd","24"));
//        //2
//        Collections.copy(cars2, cars.getCars());
//        List<Car> cars2 = new ArrayList<Car>();
//        cars1=cars.copy();


        System.out.println(cars);
//        System.out.println(cars2);

        cars.getCars().sort(Car.byNameAsc);
        System.out.println("Format by name (ascending)\n"+cars);
        System.out.println("Исходный массив: "+cars2);
        cars.getCars().sort(Car.byNameDesc);
        System.out.println("Format by name (descending)\n"+cars);
        System.out.println("Исходный массив: "+cars2);

        cars.getCars().sort(Car.byCodingAsc);
        System.out.println("Format by coding (ascending)\n"+cars);
        cars.getCars().sort(Car.byCodingDesc);
        System.out.println("Format by coding (descending)\n"+cars);

        Cars withCoding = cars.searchByCoding(1);
        System.out.println("search by coding:\n"+withCoding);
        Cars withName = cars.filterByName("Acura ");
        System.out.println("filter by name:\n"+withName);
    }
}
