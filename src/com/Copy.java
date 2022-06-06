package com;

public class Copy{
    public Car tempCar;

    public Copy(Car car){
        this.tempCar = car;
    }
    public Copy(Copy copy){
        this.tempCar = copy.tempCar;
    }
}
