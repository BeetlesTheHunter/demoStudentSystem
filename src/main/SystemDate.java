package main;


import java.time.LocalDate;

public class SystemDate {
    
    private static Integer year = LocalDate.now().getYear();
    private static Integer month =LocalDate.now().getDayOfMonth();
    private static Integer day = LocalDate.now().getDayOfMonth();


    public static String getFullDate(){
        return year.toString() + month.toString() +"0"+ day.toString();
    }

    public static String getYear(){
        return year.toString();
    }

    public static String getMonth(){
        return month.toString();
    }

    public static String getDay(){
        return day.toString();
    }


}
