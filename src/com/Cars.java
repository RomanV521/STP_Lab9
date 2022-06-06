package com;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Locale;

import static java.lang.Integer.*;

public class Cars {
    private ArrayList<Car> cars;
    public int size=0;

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

    public void remove(Car car){
        this.cars.remove(car);
    }
    public void remove(int index){
        this.cars.remove(index);
    }
//    public Cars copy(Cars cars){
//        Cars copyCars = null;
//        Car car = new Car();
//
//        for (int i=0; i < this.cars.size(); i++){
//            copyCars.add(new Car(car.getName(),car.getCoding()));
//        }
//
//        return copyCars;
//    }
    public Cars copy() throws CloneNotSupportedException{
        return (Cars) super.clone();
    }

    @Override
    public String toString() {
        String result = "------------------------\nCars :\n";
        for (Car c : cars){
            result += "\t" + c + "\n";//System.lineSeparator()
            size++;
        }
//        for (int i=0; i < 10; i++){
//            result += "\t" + cars.get(i) + "\n";//System.lineSeparator()
//        }

        return result;
    }

    public Cars filterByName(String name){

        Cars tempCars = new Cars();
        for (Car car : this.cars){
            if (car.getName().toLowerCase().contains(name.strip().toLowerCase())){

                tempCars.add(car);
            }
        }
        return tempCars;
    }
    public Cars searchByCoding(int coding){
        Cars tempCars = new Cars();
        for (Car car : this.cars){
            if (parseInt(car.getCoding()) == coding){
                tempCars.add(car);
            }
        }
        return tempCars;
    }
}
