/*
* Author: Ping Danddank
2. Write a Java program to convert minutes into a number of years and days.
Test Data
Input the number of minutes: 3456789
Expected Output :
3456789 minutes is approximately 6 years and 210 days.
 */
public class TimeConvertor {
    public static void main(String[] args) {
        minutesToYearsAndDays(3456789);
    }
    // to convert from minutes to year and day, and print them out.
    public static void minutesToYearsAndDays(int minutes){
        int years = minutes / (365*24*60);
        int days = (minutes % (365*24*60))/(24*60);
        System.out.println(String.format("%d minutes is approximately %d years and %d days", minutes, years, days));
    }
}
