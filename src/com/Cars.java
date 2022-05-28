package com;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Cars {
    private ArrayList<Car> cars;

    public ArrayList<Car> getCars(){
        return cars;
    }

    public Cars(ArrayList<Car> cars){
        this.cars = cars;
    }

    public void setCar(ArrayList<Car> cars){
        this.cars = cars;
    }

    public Cars(){
        cars = new ArrayList<>();
    }

    public void add(Car car){
        this.cars.add(car);
    }

    @Override
    public String toString() {
        String result = "------------------------\nCars :\n";
        for (Car c : cars){
            result += "\t" + c + "\n";//System.lineSeparator()
        }
//        for (int i=0; i< 10; i++){
//            result += "\t" + cars.get(i) + "\n";//System.lineSeparator()
//        }

        return result;
    }
}
