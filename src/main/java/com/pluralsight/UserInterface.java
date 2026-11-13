package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class UserInterface {

    private static Dealership dealership;

    private void init() {
        DealershipFileManager.readFromFile();
        dealership = App.dealership;
        System.out.println(dealership.toRow());
    }
    protected void displayMainMenu() {
        init();
        int intAnswer;
        do {
            System.out.print("""
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type (car, truck, SUV, van)
                    7 - List ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit""" + "\n");

            intAnswer = App.promptToInt("Enter command here -> ");
            switch (intAnswer) {
                case 1 -> findVehiclesByPrice();
                case 2 -> findVehiclesByMakeModel();
                case 3 -> findVehiclesByYear();
                case 4 -> findVehiclesByColor();
                case 5 -> findVehiclesByMileage();
                case 6 -> findVehiclesByType();
                case 7 -> listAllVehicles();
                case 8 -> addVehicle();
                case 9 -> removeVehicle();
                default -> {if (intAnswer != 99) System.out.println("request out of scope try again");}
            }
        } while (intAnswer != 99);
    }

    private static void findVehiclesByPrice() {dealership.findVehiclesByPrice();}
    private static void findVehiclesByMakeModel() {dealership.findVehiclesByMakeModel();}

    private void findVehiclesByYear() {dealership.findVehiclesByYear();}
    private void findVehiclesByColor() {dealership.findVehiclesByColor();}

    private void findVehiclesByMileage() {dealership.findVehiclesByMileage();}
    private void findVehiclesByType() {dealership.findVehiclesByType();}

    private void listAllVehicles() {dealership.listAllVehicles();}
    private void addVehicle() {
        Vehicle vehicle = new Vehicle();
        String strAnswer;
        boolean isComplete = false;
        String[] vehicleFields = {"vin", "year", "make", "model", "type", "color", "price"};
        for (int i = 0; i <= vehicleFields.length; i++){
            switch (vehicleFields[i]) {
                case "vin"-> {
                    while (true) {
                        System.out.print("please enter vehicle vin or enter `-C` to cancel back" +
                                "enter here -> ");
                        strAnswer = App.scanner.nextLine().trim();
                        if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                            i +=vehicleFields.length;
                        } else if (App.canParseStringToInt(strAnswer)) {
                            vehicle.setVin(Integer.parseInt(strAnswer));
                            break;
                        } else System.out.println("invalid Command\n");
                    }
                }
                case "type"-> {
                    System.out.print("please enter vehicle type or enter `-C` to cancel out" +
                            "enter here -> ");
                    strAnswer = App.scanner.nextLine().trim();
                    if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                        i -= 2;
                    } else {
                        vehicle.setType(strAnswer);
                    }
                }
                case "make"-> {
                    System.out.print("please enter vehicle make or enter `-C` to cancel out" +
                            "enter here -> ");
                    strAnswer = App.scanner.nextLine().trim();
                    if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                        i -= 2;
                    } else {
                        vehicle.setMake(strAnswer);
                    }
                }
                case "model"-> {
                    System.out.print("please enter vehicle model or enter `-C` to cancel out" +
                            "enter here -> ");
                    strAnswer = App.scanner.nextLine().trim();
                    if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                        i -= 2;
                    } else {
                        vehicle.setModel(strAnswer);
                    }
                }
                case "price" -> {
                    while (true) {
                        System.out.print("please enter vehicle price or enter `-C` to cancel back" +
                                "enter here -> ");
                        strAnswer = App.scanner.nextLine().trim();
                        if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                            i -=2;
                        } else if (App.canParseStringToDecimal(strAnswer)) {
                            vehicle.setPrice(BigDecimal.valueOf(Double.parseDouble(strAnswer)));
                            break;
                        } else System.out.println("invalid Command\n");
                    }
                }
                case "year" -> {
                    while (true) {
                        System.out.print("please enter vehicle year(e.g 2006) or enter `-C` to cancel back" +
                                "enter here -> ");
                        strAnswer = App.scanner.nextLine().trim();
                        if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                            i -= 2;
                        } else if (App.canParseStringToInt(strAnswer)) {
                            vehicle.setYear(Integer.parseInt(strAnswer));
                            break;
                        } else System.out.println("invalid Command\n");
                    }
                }
                case "color"->{
                    System.out.print("please enter vehicle color or enter `-C` to cancel back" +
                            "enter here -> ");
                    strAnswer = App.scanner.nextLine().trim();
                    if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                        i -= 2;
                    } else {
                        vehicle.setColor(strAnswer);
                        isComplete = !isComplete;
                    }
                }
            }
        }
        if (isComplete) {dealership.addVehicle(vehicle);}
    }
    private void removeVehicle() {dealership.removeVehicle();}

    public static ArrayList<Vehicle> DealershipVehicleList() {
        return dealership.getVehicleList();
    }
}
