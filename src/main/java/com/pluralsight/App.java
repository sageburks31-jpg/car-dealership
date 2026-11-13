package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.math.*;
import static java.lang.Thread.*;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Dealership dealership;

    public static void readFromFile() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            while((input = bufReader.readLine()) != null) {
                String[] lineSegment = input.split("\\|");
                if (lineSegment.length>2 && canParseStringToInt(lineSegment[0])) {
                    Vehicle transaction = getVehicle(lineSegment);
                    dealership.addVehicle(transaction);
                } else {
                    dealership = new Dealership(lineSegment[0],lineSegment[1],lineSegment[2]);
                }
            }
            bufReader.close();
        } catch (IOException e) {throw new RuntimeException(e);}
    }

    private static Vehicle getVehicle(String[] lineSegment) {
        int vin = Integer.parseInt(lineSegment[0]);
        int year = Integer.parseInt(lineSegment[1]) ;
        String make = lineSegment[2];
        String model = lineSegment[3];
        String type = lineSegment[4];
        String color = lineSegment[5];
        int odometer = Integer.parseInt(lineSegment[6]);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(lineSegment[7]));
        return new Vehicle(vin, year, make, model, type, color, odometer, price);
    }

    public static void writeToFile() {}

    public static void main(String[] args) {
        readFromFile();
        displayMainMenu();
        System.out.print("thank you for using this program");
        scanner.close();
    }

    private static void displayMainMenu() {
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
                default -> System.out.println("request out of scope try again");
            }
        } while (intAnswer != 99);
    }

    public static int promptToInt(String prompt) {
        do {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
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
                return BigDecimal.valueOf(Long.parseLong(scanner.nextLine().trim()));
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

    private static void findVehiclesByPrice() {}
    private static void findVehiclesByMakeModel() {}

    private static void findVehiclesByYear() {}
    private static void findVehiclesByColor() {}

    private static void findVehiclesByMileage() {}
    private static void findVehiclesByType() {}

    private static void listAllVehicles() {}
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
                        strAnswer = scanner.nextLine().trim();
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
                    strAnswer = scanner.nextLine().trim();
                    if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                        i -= 2;
                    } else {
                        vehicle.setType(strAnswer);
                    }
                }
                case "make"-> {
                    System.out.print("please enter vehicle make or enter `-C` to cancel out" +
                            "enter here -> ");
                    strAnswer = scanner.nextLine().trim();
                    if (strAnswer.equals("-C") || strAnswer.equals("-c")) {
                        i -= 2;
                    } else {
                        vehicle.setModel(strAnswer);
                    }
                }
                case "model"-> {
                    System.out.print("please enter vehicle model or enter `-C` to cancel out" +
                            "enter here -> ");
                    strAnswer = scanner.nextLine().trim();
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
                        strAnswer = scanner.nextLine().trim();
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
                        strAnswer = scanner.nextLine().trim();
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
                        strAnswer = scanner.nextLine().trim();
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
        if (isComplete) {dealership.addVehicle(vehicle);}
    }
    private static void removeVehicle() {}
}