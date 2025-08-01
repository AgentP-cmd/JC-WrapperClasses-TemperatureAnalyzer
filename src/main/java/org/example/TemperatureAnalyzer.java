package org.example;
import java.util.Scanner;

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Day 1 High Temperature (e.g., 28.5): ");
        String day1TempStr = sc.nextLine().trim();
        System.out.print("Enter Day 2 High Temperature (e.g., 28.5): ");
        String day2TempStr = sc.nextLine().trim();
        System.out.print("Enter Day 3 High Temperature (e.g., 28.5): ");
        String day3TempStr = sc.nextLine().trim();
        System.out.println();

        double day1TempPrimitive;
        double day2TempPrimitive;
        try {
            System.out.println("---Temperature Analysis ---");
            System.out.println();
            day1TempPrimitive = Double.parseDouble(day1TempStr);
            System.out.println("Parsed Day 1 Temp (primitive double): " + day1TempPrimitive);
            day2TempPrimitive = Double.parseDouble(day2TempStr);
            System.out.println("Parsed Day 2 Temp (primitive double): " + day2TempPrimitive);
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numeric temperatures.");
            return;
        }

        Double day1TempWrapper = Double.valueOf(day1TempPrimitive);
        Double day2TempWrapper = Double.valueOf(day2TempPrimitive);
        int result = day1TempWrapper.compareTo(day2TempWrapper);
        if (result > 0){
            System.out.println("Day 1 (" + day1TempWrapper + "°C) was warmer than Day 2 (" + day2TempWrapper +"°C)");
        } else if (result < 0){
            System.out.println("Day 1 (" + day1TempWrapper + "°C) was cooler than Day 2 (" + day2TempWrapper +"°C)");
        } else {
            System.out.println("Day 1 (" + day1TempWrapper + "°C) has a same temperature as Day 2 (" + day2TempWrapper +"°C)");
        }

        float day1TempFloat = day1TempWrapper.floatValue();
        int day2TempInt = day2TempWrapper.intValue();
        System.out.println();
        System.out.println("Extracted Day 1 Temp (primitive float from Double wrapper): " + day1TempFloat);
        System.out.println("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): " + day2TempInt);
        System.out.println();

        double day3TempPrimitive;
        try {
            day3TempPrimitive = Double.parseDouble(day3TempStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric temperature for Day 3.");
            return;
        }
        Double day3TempWrapper = Double.valueOf(day3TempPrimitive);

        double highTemp = Math.max(Math.max(day1TempWrapper,day2TempWrapper), day3TempWrapper);

        System.out.println("The highest temperature recorded was: " + highTemp + "°C");
    }
}
