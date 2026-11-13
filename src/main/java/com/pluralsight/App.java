package com.pluralsight;

import java.util.*;
import java.time.*;
import java.math.*;
import static java.lang.Thread.*;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
        System.out.println("thank you for using this program");
    }

    private static void displayMainMenu() {
        int intAnswer;
        do {
            System.out.println("""
                    1 - Find vehicles within a price range
                    2 - Find vehicles by make / model
                    3 - Find vehicles by year range
                    4 - Find vehicles by color
                    5 - Find vehicles by mileage range
                    6 - Find vehicles by type (car, truck, SUV, van)
                    7 - List ALL vehicles
                    8 - Add a vehicle
                    9 - Remove a vehicle
                    99 - Quit""");

            intAnswer = promptToInt("Enter command here -> ");
            switch (intAnswer) {
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {}
                case 7 -> {}
                case 8 -> {}
                case 9 -> {}
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

}