package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Features.Login;
import Objects.Reservation;
import Objects.Student;
import Objects.Teacher;

public class App {
    public static ArrayList<Student> studentList = new ArrayList<Student>();
    private static HashMap<String,Student> studentMap = new HashMap<String,Student>();
    private static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();//teacherList作成
    private static ArrayList<Reservation> reservationList = new ArrayList<Reservation>();//reservationList作成


    public static String globalDate = SystemDate.getFullDate();//これで現在を参照してね。
    public static int globalPointMin = 4;


    public static void main(String[] args) throws Exception {
        loadReservation();//ロード追加
        loadStudent();//ロード追加
        loadTeacher();//ロード追加

        Login l = new Login();
        l.loginScreen();

    }

    public static Student findStudent(String _ID){
        return studentMap.get(_ID); //Student のリストからIDで探します。
    }

    private static void makeStudentMap(){
        for (int i = 0; i < studentList.size(); i++){
            studentMap.put(studentList.get(i).getStudentId(), studentList.get(i));
        }
    }
    
    //ロード関数３つ作成
    public static void loadStudent() {
        String fileName = "student.csv"; //仮テスト用ファイル作った
        try(BufferedReader br = new BufferedReader(new FileReader(fileName));) {
            String line;
            while((line = br.readLine())!=null){
                String[] data = line.split(","); //ファイルがコンマで区切り想定
                boolean isToeic = data[3].equalsIgnoreCase("true");
                // Student s = new Student(data[0],data[1],data[2],isToeic,data[4],Integer.parseInt(data[5]),data[6]);
                Student s = new Student();
                s.setStudentId(data[0].trim()); 
                s.setName(data[1].trim());
                s.setPw(data[2].trim());
                s.setToeic(isToeic);
                s.setTeacherId(data[4].trim());
                s.setPoint(Integer.parseInt(data[5].trim()));
                s.setPointDelDate(data[6].trim());
                studentList.add(s);
            }          
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
        makeStudentMap(); //makeStudentMapを追加しました 
    }    
    
    public static void loadTeacher(){
        String fileName = "teacher.csv"; //仮ファイル名前、未作成
        try(BufferedReader br = new BufferedReader(new FileReader(fileName));) {
            String line;
            while((line = br.readLine())!=null){
                String[] data = line.split(","); //ファイルがコンマで区切り想定
                Teacher t = new Teacher();
                t.setTeacherId(data[0].trim());
                t.setName(data[1].trim());
                teacherList.add(t);
            }           
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void loadReservation(){
        String fileName = "reservation.csv"; //仮ファイル名前、未作成
        try(BufferedReader br = new BufferedReader(new FileReader(fileName));) {
            String line;
            while((line = br.readLine())!=null){
                String[] data = line.split(","); //ファイルがコンマで区切り想定
                Reservation r = new Reservation();
                r.setStudentId(data[0].trim());
                r.setTeacherId(data[1].trim());
                r.setDate(data[2].trim());
                r.setTime(data[3].trim());
            }           
        }catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }   
}


    

