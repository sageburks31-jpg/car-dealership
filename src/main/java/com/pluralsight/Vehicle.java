package com.pluralsight;

import java.math.*;

public class Vehicle {
    private String type;
    private int makeModel;
    private BigDecimal mileage;
    private String year;
    private String color;

    public Vehicle() {}
    public Vehicle(String color, String year, BigDecimal mileage, int makeModel, String type) {
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.makeModel = makeModel;
        this.type = type;
    }

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public int getMakeModel() {return makeModel;}
    public void setMakeModel(int makeModel) {this.makeModel = makeModel;}

    public BigDecimal getMileage() {return mileage;}
    public void setMileage(BigDecimal mileage) {this.mileage = mileage;}

    public String getYear() {return year;}
    public void setYear(String year) {this.year = year;}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
}
