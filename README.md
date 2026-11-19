# Car Dealership README


## About Me

Description Here -

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