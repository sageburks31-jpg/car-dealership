package com.pluralsight;

import java.util.*;

public class Dealership {
    private String name;
    private String phoneNumber;
    private String address;
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public Dealership() {}
    public Dealership(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }
    public void listAllVehicles() {
        vehicleList.forEach(vehicle -> System.out.println(vehicle.toRow()));
    }
    public void removeVehicle() {
        Scanner scanner =new Scanner(System.in);
        vehicleList.forEach(vehicle -> System.out.println(vehicle.toShortRow()));
        System.out.println("Enter vehicle vin number to remove from list");
        int vinKey = UserInterface.promptToInt("Enter VIN number here -> ");
        int targetIndex = -1;
        for (int i = 0; i < vehicleList.size()-1; i++) {
            if (vehicleList.get(i).getVin()==vinKey) {
                targetIndex=i;
                break;
            }
        }
        if (targetIndex>-1) vehicleList.remove(targetIndex);
    }
    public void findVehiclesByPrice() {

    }
    public void findVehiclesByMakeModel() {}

    public void findVehiclesByYear() {}
    public void findVehiclesByColor() {}

    public void findVehiclesByMileage() {}
    public void findVehiclesByType() {}

}
