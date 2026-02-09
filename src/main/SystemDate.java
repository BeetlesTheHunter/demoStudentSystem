package main;

import java.time.LocalDate;
import java.util.Scanner;

public class SystemDate {
    
    private static Integer year = LocalDate.now().getYear();
    private static Integer month = LocalDate.now().getDayOfMonth();
    private static Integer day = LocalDate.now().getDayOfMonth();

    private static Scanner sc = new Scanner(System.in);

    public static String setDate(){//yyyymmdd方式で入力絶対
        String date;
        while(true){
            System.out.println("yyyymmdd方式で入力してください。");
            System.out.println("例:2025年1月1日は 20250101で入力します。");
            date = sc.nextLine();

            if(date.length() != 8){
                System.out.println("yyyymmddで入力してください。");
                continue;
            }
            System.out.println(date);
            System.out.println(date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3) + "年");
            System.out.println(date.charAt(4) + date.charAt(5) + "月");
            System.out.println(date.charAt(6) + date.charAt(7) + "日");
            System.out.println(getWeekDay(date));
            System.out.println("よろしいいですか？");

            System.out.println(" ");
            System.out.println("1:はい");
            System.out.println("2:いいえ");

            
            while (true){
                String choice = sc.nextLine();
                if(choice != "1") continue;
                break;
            }

            break;
        }

        
        
        return date;
    }

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

    private static String getWeekDay(String date){
        int year = (date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3));
        int month = (date.charAt(4) + date.charAt(5));
        int day = (date.charAt(6) + date.charAt(7));
        var d = LocalDate.of(year,month,day);
        return d.getDayOfWeek().toString();
    }


}
