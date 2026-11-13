package com.pluralsight;

import java.math.BigDecimal;
import java.util.*;

public class Dealership {
    private final String name;
    private final String phoneNumber;
    private final String address;
    private final ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public Dealership(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

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
        int vinKey = App.promptToInt("Enter VIN number here -> ");
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
        BigDecimal minPrice = App.promptToBigDecimal("please enter price minim here -> ");
        BigDecimal maxPrice = App.promptToBigDecimal("please enter price maxim here -> ");
        for (Vehicle vehicle : vehicleList) {
            if (App.getDecimal(vehicle.getPrice()) > App.getDecimal(minPrice) && App.getDecimal(vehicle.getPrice()) < App.getDecimal(maxPrice)){
                System.out.println(vehicle.toRow());
            }
        }
    }
    public void findVehiclesByMakeModel() {
        String makeModel =App.promptToString("enter the make and model of the vehicle\nEnter here(make-model) -> ");
        String[] makeModelList = makeModel.split("-");
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getMake().equals(makeModelList[0]) && vehicle.getModel().equals(makeModelList[1])){
                System.out.println(vehicle.toRow());
            }
        }
    }

    public void findVehiclesByYear() {
        int minPrice = App.promptToInt("please enter year minim here -> ");
        int maxPrice = App.promptToInt("please enter year maxim here -> ");
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getYear()>minPrice && vehicle.getYear() < maxPrice){
                System.out.println(vehicle.toRow());
            }
        }
    }
    public void findVehiclesByColor() {
        String makeModel = App.promptToString("enter the Color of the vehicle\nEnter here -> ");
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getColor().equals(makeModel)){
                System.out.println(vehicle.toRow());
            }
        }
    }

    public void findVehiclesByMileage() {
        int minPrice = App.promptToInt("please enter year minim here -> ");
        int maxPrice = App.promptToInt("please enter year maxim here -> ");
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getOdometer()>minPrice && vehicle.getOdometer() < maxPrice){
                System.out.println(vehicle.toRow());
            }
        }
    }
    public void findVehiclesByType() {
        String makeModel = App.promptToString("enter the Type of the vehicle\nEnter here -> ");
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getColor().equals(makeModel)){
                System.out.println(vehicle.toRow());
            }
        }
    }

}
