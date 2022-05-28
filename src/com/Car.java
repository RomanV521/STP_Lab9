package com;

import java.util.Comparator;

public class Car {

    private String name;
    private String coding;

    /**
     * No args constructor for use in serialization
     *
     */
    public Car() {
    }

    /**
     *
     * @param coding
     * @param name
     */
    public Car(String name, String coding) {
        super();
        this.name = name;
        this.coding = coding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    @Override
    public String toString() {
        return "Car "+
                "name: " + name + "\n" +
                "\tcoding: " + coding + "\n";
    }

    public static Comparator<Car> byNameAsc = Comparator.comparing(o -> o.name);
    public static Comparator<Car> byNameDesc = (o, o1) -> o1.name.compareTo(o.name);

    public static Comparator<Car> byCodingAsc = (o, o1) -> Integer.parseInt(o.coding) > Integer.parseInt(o1.coding) ? 1 : Integer.parseInt(o.coding) < Integer.parseInt(o1.coding) ? -1 : 0;
    public static Comparator<Car> byCodingDesc = (o, o1) -> Integer.parseInt(o.coding) < Integer.parseInt(o1.coding) ? 1 : Integer.parseInt(o.coding) > Integer.parseInt(o1.coding) ? -1 : 0;
}