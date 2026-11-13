package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.lang.Thread.sleep;

public class UserInterface {
    protected static void displayMainMenu() {
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

            intAnswer = promptToInt("Enter command here -> ");
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

    public static int promptToInt(String prompt) {
        do {
            try {
                System.out.print(prompt);
                return Integer.parseInt(App.scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("command is invalid\n");
                try {
                    sleep(900);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } while (true);
    }
    public static BigDecimal promptToBigDecimal(String prompt) {
        do {
            try {
                System.out.print(prompt);
                return BigDecimal.valueOf(Long.parseLong(App.scanner.nextLine().trim()));
            } catch (NumberFormatException e) {
                System.out.println("command is invalid\n");
                try {
                    sleep(900);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } while (true);
    }

    public static boolean canPromptToYear(String prompt) {
        LocalDate parse = LocalDate.now();
        try {
            parse = LocalDate.parse(prompt);
            return true;
        } catch (NumberFormatException e) {
            System.out.print(parse);
            return false;
        }
    }
    public static boolean canParseStringToInt(String prompt) {
        try {
            Integer.parseInt(prompt);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean canParseStringToDecimal(String prompt) {
        try {
            Double.parseDouble(prompt);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void findVehiclesByPrice() {App.dealership.findVehiclesByPrice();}
    private static void findVehiclesByMakeModel() {App.dealership.findVehiclesByMakeModel();}

    private static void findVehiclesByYear() {App.dealership.findVehiclesByYear();}
    private static void findVehiclesByColor() {App.dealership.findVehiclesByColor();}

    private static void findVehiclesByMileage() {App.dealership.findVehiclesByMileage();}
    private static void findVehiclesByType() {App.dealership.findVehiclesByType();}

    private static void listAllVehicles() {App.dealership.listAllVehicles();}
    private static void addVehicle() {
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
                        } else if (canParseStringToDecimal(strAnswer)) {
                            vehicle.setPrice(BigDecimal.valueOf(Double.parseDouble(strAnswer)));
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
                        vehicle.setModel(strAnswer);
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
                        } else if (canParseStringToDecimal(strAnswer)) {
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
                        } else if (canParseStringToInt(strAnswer)) {
                            vehicle.setYear(Integer.parseInt(strAnswer));
                            break;
                        } else System.out.println("invalid Command\n");
                    }
                }
                case "color"->{
                    while (true) {
                        System.out.print("please enter vehicle color or enter `-C` to cancel back" +
                                "enter here -> ");
                        strAnswer = App.scanner.nextLine().trim();
                        if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                            i -= 2;
                        } else if (strAnswer.equals("blue")) {
                            vehicle.setType(strAnswer);
                            isComplete = !isComplete;
                            break;
                        } else System.out.println("invalid Command\n");
                    }

                }
            }
        }
        if (isComplete) {App.dealership.addVehicle(vehicle);}
    }
    private static void removeVehicle() {App.dealership.removeVehicle();}
}
