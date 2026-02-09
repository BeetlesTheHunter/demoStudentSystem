package main;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

/*
    関数マニュアル

    SystemDate.getFullDate()
        Stringで今日の日付を返す

    SystemDate.getFullDateAsInt()
        intで今日の日付を返す

    SystemDate.setDate()
        String を返す
        呼ぶ時にScannerがユーザの入力を読む必ずyyyymmddで入力するように。
    
    SystemDate.setPointDelDate()
        intで来年の日付を返す
        ポイントを消す日付です

*/

public class SystemDate {
    
    private static Integer year = LocalDate.now().getYear();
    private static Integer month = LocalDate.now().getMonthValue();
    private static Integer day = LocalDate.now().getDayOfMonth();

    private static Scanner sc = new Scanner(System.in);

    public static String setDate(){//yyyymmdd方式で入力絶対
        String date;
        while(true){
            System.out.println("yyyymmdd方式で入力してください。");
            System.out.println("例:2025年1月1日は 20250101で入力します。");
            date = sc.nextLine();

            int year = Integer.parseInt(Character.toString(date.charAt(0)) + Character.toString(date.charAt(1)) + Character.toString(date.charAt(2))  + Character.toString(date.charAt(3)));
            int month = Integer.parseInt(Character.toString(date.charAt(4)) + Character.toString(date.charAt(5)));
            int day = Integer.parseInt(Character.toString(date.charAt(6)) + Character.toString(date.charAt(7)));

            if(date.length() != 8){
                System.out.println("yyyymmddで入力してください。");
                continue;
            }
            if(month >= 13){
                System.out.println("1-12までの月を入力してください。");
                continue;
            }
            if(day >= 32){
                System.out.println("1-31までの日を入力してください。");
                continue;
            }
            if(month == 2){
                if(Year.isLeap(year) && day >= 29){
                    System.out.println("2月は28日までです。");
                    continue;
                }else if (day >= 28){
                    System.out.println("2月は27日までです。");
                    continue;
                }
            }

            System.out.println(date);
            System.out.println(year+ "年");
            System.out.println(month + "月");
            System.out.println(day + "日");
            System.out.println(getWeekDay(year,month,day));
            System.out.println("よろしいいですか？");

            System.out.println(" ");
            System.out.println("1:はい");
            System.out.println("2:いいえ");

            
            while (true){
                String choice = sc.nextLine();
                if(!choice.equals("1")) continue;
                break;
            }
            break;
        }

        return date;
    }

    public static int setPointDelDate(){
        return Integer.parseInt(getFullDate()) + 10000;
    }

    public static String getFullDate(){
        return (datetoInt()).toString();
    }


    public static int getFullDateAsInt(){
        return datetoInt();
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

    private static String getWeekDay(int year,int month,int day){
        var d = LocalDate.of(year,month,day);
        return d.getDayOfWeek().toString();
    }

    private static Integer datetoInt(){
        return ((year*10000)+(month*100)+day);
    }


}
