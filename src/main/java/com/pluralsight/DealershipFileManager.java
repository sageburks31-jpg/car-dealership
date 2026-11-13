package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {

    public static void readFromFile() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            while((input = bufReader.readLine()) != null) {
                String[] lineSegment = input.split("\\|");
                if (lineSegment.length>2 && App.canParseStringToInt(lineSegment[0])) {
                    Vehicle transaction = getVehicle(lineSegment);
                    App.dealership.addVehicle(transaction);
                } else {
                    App.dealership = new Dealership(lineSegment[0],lineSegment[1],lineSegment[2]);
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
    public static void writeToFile(boolean append) {
        try {
            FileWriter fileWriter = new FileWriter("inventory.csv", append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if (append) {
                bufferedWriter.append(UserInterface.DealershipVehicleList().get(UserInterface.DealershipVehicleList().size() - 1).toRow());
                bufferedWriter.newLine();
            } else {
                if (!UserInterface.DealershipVehicleList().isEmpty()) {
                    for (int i = 0; i < UserInterface.DealershipVehicleList().size(); i++) {
                        bufferedWriter.append(UserInterface.DealershipVehicleList().get(i).toRow());
                        bufferedWriter.newLine();
                    }
                }

            }
            bufferedWriter.close();
        } catch(IOException e) {System.out.println("fail");}
    }

}
