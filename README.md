# Car Dealership 


### Description

This console application is for a used car dealership sales manager. It loads the dealership and its vehicles from inventory.csv, and lets the user search the inventory, and when you add or remove a vehicle from the loaded file it will update the inventory.csv directly.


---
### Run it
Run `Program.main()` from IntelliJ with the project folder as the working directory, so `inventory.csv` is found.

---
### ScreenShot

Class location:  UserInterFace.java 
![Screenshot 2026-11-19 at 2.32.23 PM.png](Screenshot%202026-11-19%20at%202.32.23%E2%80%AFPM.png)
---
### Interesting Code

Location: Class- App.java, lines- 83 to 98
```java
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
```

---