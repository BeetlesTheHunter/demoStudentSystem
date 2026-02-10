package Features;

import Objects.Reservation;
import Objects.Student;
//import Objects.Teacher;

import java.util.ArrayList;
import java.util.Scanner;
import main.App;

public class Booking {
    static Scanner sc = new Scanner(System.in);
    

    public void viewReservation(String id){//予約確認(二つに分けたけど分けんでもよかったわ)
        String first = id.substring(0, 1);
        if(first.equals("s")){
            //生徒用
            Boolean flag=false;
            for(int i=0;i<App.reservationList.size();i++){
                Reservation r =App.reservationList.get(i);
                flag=true;
                if((r.getStudentId()).equals(id)){
                    System.out.println(r.getDate()+" "+r.getTime());
                }
            }
            if(!flag){
                System.out.println("予約はありません。");
            }
            System.out.println();
            return;
        }
        if(first.equals("t")){
            //教師用
            Boolean flag=false;
            for(int i=0;i<App.reservationList.size();i++){
                Reservation r =App.reservationList.get(i);
                flag=true;
                if((r.getStudentId()).equals(id)){
                    System.out.println(r.getDate()+" "+r.getTime());
                }
            }
            if(!flag){
                System.out.println("予約はありません。");
            }
            System.out.println();
            return;
        }
    }//viewReservation()

    //予約時はこの関数を呼び出して（グループ授業は未完成です。）
    public void booking(String id){//生徒のidを渡す。
        System.out.printf("1対1での授業を希望しますか（y/n）:");
        String input="";
        while(true){
            input=sc.nextLine();
            if(input.equals("y") || input.equals("n")){
                break;
            }
            System.out.println("yかnで入力してください");
        }
        if(input.equals("y")){
            SoroBooking(id);
            return;
        }
        if(input.equals("n")){
            GroupBppking(id);
            return;
        }
    }//booking()

    public void SoroBooking(String id){
        Student s=null;
        for(int i=0;i<App.studentList.size();i++){
            if(((App.studentList.get(i)).getStudentId()).equals(id)){
                s=App.studentList.get(i);
            }
        }
        if(s.getPoint()<9){
            System.out.println("ポイント不足です。");
            return;
        }

        String tid=s.getTeacherId();
        String date;
        System.out.println("1対1での授業を予約します。");

        while(true){
            ArrayList<String> timetable = new ArrayList<String>();
            timetable.add("10:00");
            timetable.add("11:00");
            timetable.add("12:00");
            timetable.add("13:00");
            timetable.add("14:00");
            timetable.add("15:00");
            timetable.add("16:00");
            timetable.add("17:00");
            timetable.add("18:00");
            timetable.add("19:00");
            timetable.add("20:00");
            timetable.add("21:00");
            
            System.out.printf("予約する日付を入力してください（yyyy-mm-dd）9999を入力で予約を中止する:");
            date=sc.nextLine();
            if(date.equals("9999")){
                System.out.println("予約を中止します。");
                return;
            }
            if (date.matches("\\d{4}-\\d{2}-\\d{2}")){
                //予約できないコマを削除
                for(int i=0;i<App.reservationList.size();i++){
                    Reservation r=App.reservationList.get(i);
                    //if(!(r.getStudentId()).equals(id))continue;
                    if(!(r.getTeacherId()).equals(tid))continue;
                    if((r.getDate()).equals(date)){
                        timetable.remove(r.getTime());
                    }
                }
                //枠が空いない
                if(timetable.size()==0){
                    System.out.println(date+"には予約できる枠がありません。");
                    continue;
                }
                //枠が空いている
                System.out.println("予約する時間を選んでください");
                for(int i=0;i<timetable.size();i++){
                    System.out.println(i+":"+timetable.get(i));
                }
                String tmp;
                int idx;
                while(true){
                    System.out.printf("数字で入力してください(99を入力で中止します。)：");
                    tmp=sc.nextLine();
                    try{
                        idx = Integer.parseInt(tmp);
                    }catch(Exception e){
                        System.out.println("無効な入力です。");
                        continue;
                    }
                    if(idx==99)break;
                    if(idx>=timetable.size()){
                        System.out.println("無効な入力です。");
                        continue;
                    }
                }
                if(idx==99){
                    continue;
                }
                String time=timetable.get(idx);
                checkOK(id,tid,date,time);
                s.setPoint(s.getPoint()-9);
                App.saveStudent();
            }else{
                System.out.println("正しい形式で入力してください（例：2000-01-23）");
                continue;
            }

        }


    }
    public void GroupBppking(String id){//未完成
        System.out.println("グループ授業は未完成のため、予約ができません。");
    }


    public void checkOK(String studentID,String teacherID,String date,String time){
        System.out.println(date+time+"に予約します。");
        
        //reservationListにインスタンスを追加
        (App.reservationList).add(new Reservation());
        int idx=(App.reservationList).size();
        Reservation r=App.reservationList.get(idx);
        r.setStudentId(studentID);
        r.setTeacherId(teacherID);
        r.setTime(time);
        r.setDate(date);
        //reservationListをcsvに書き込む
        App.saveReservation();
        
    }


}
