package com.pluralsight;

import java.util.*;
import java.time.*;
import java.math.*;
import static java.lang.Thread.*;

public class App {

    static ArrayList<Vehicle> vehicleList;
    static Scanner scanner = new Scanner(System.in);

    public static void readFromFile() {}
    public static void writeToFile() {}

    public static void main(String[] args) {
        readFromFile();
        displayMainMenu();
        System.out.print("thank you for using this program");
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

    private static void findVehiclesByPrice() {}
    private static void findVehiclesByMakeModel() {}

    private static void findVehiclesByYear() {}
    private static void findVehiclesByColor() {}

    private static void findVehiclesByMileage() {}
    private static void findVehiclesByType() {}

    private static void listAllVehicles() {}
    private static void addVehicle() {}
    private static void removeVehicle() {}
}