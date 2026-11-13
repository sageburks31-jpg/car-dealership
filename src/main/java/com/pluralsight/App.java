package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.math.*;
import static java.lang.Thread.*;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Dealership dealership;

    public static void main(String[] args) {
        DealershipFileManager.readFromFile();
        UserInterface.displayMainMenu();
        System.out.print("thank you for using this program");
        scanner.close();
    }


}