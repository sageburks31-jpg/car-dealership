package com.pluralsight;

import java.math.*;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String type;
    private String color;
    private int odometer;
    private BigDecimal price;

    public Vehicle() {}

    public Vehicle(int vin, int year, String make, String model, String type, String color, int odometer, BigDecimal price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}

    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    public int getVin() {return vin;}
    public void setVin(int vin) {this.vin = vin;}

    public String getMake() {return make;}
    public void setMake(String make) {this.make = make;}

    public int getOdometer() {return odometer;}
    public void setOdometer(int odometer) {this.odometer = odometer;}
}
