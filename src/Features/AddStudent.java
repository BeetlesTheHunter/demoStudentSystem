package Features;

import Objects.Student;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import main.App;
import main.SystemDate;

public class AddStudent {
    static Scanner sc = new Scanner(System.in);
    public void addStudentScreen(){
        System.out.println("--------入会システム--------");
        while (true) {
            System.out.println("[1]: 生徒入会");
            System.out.println("[2]: システム終了");
            System.out.println("[3]: ログアウト");
            System.out.println("[4]: 前のページ");
            String choose = sc.next();
            switch (choose) {
                case "1" :
                    System.out.println("入会手続きを開始します");
                    addStudent();
                    continue;
                case "2" :
                    System.out.println("システム終了します");
                    System.exit(0);
                case "3" :
                    System.out.println("ログアウトします、ログイン画面に戻ります");
                    System.out.println("--------------------------------------------------------");
                    return;
                case "4" :
                    return;
                default :
                 System.out.println("もう一度入力してください");
                 continue;
            }
        }


    }

    private void addStudent(){
        String StudentId = createStudentId();
        System.out.println("生徒名を入力してください");
        String studentName = sc.next(); //生徒名入力

        System.out.println("Toeicを選択しますか? y/n");
        String toeic = sc.next();
        boolean isToeic = toeic.equalsIgnoreCase("y"); //Toeic選択

        System.out.println("担当したい教師IDを入力 例:t001");
        String teacherId = sc.next(); //教師選択

        int point = 0;
       
        while (true) { //ポイント購入チェック
            System.out.println("購入するポイントを入力 (購入条件は最低限200ポイントおよび200ポイントごとしか買えない)");
            point = sc.nextInt();
            if(!new BuyPoint().checkBuyPoint(point)){
                System.out.println("正しくないポイント数です、もう一度入力してください");
                continue;
            }else break;
        }

        String course = "";
        while (true) { //コース選択
            System.out.println("コースを選択(low,upper,high)");
            course = sc.next();    //コース選択
            if(!(course.equals("low") || course.equals("upper") || course.equals("high"))){
                System.out.println("入力ミス、もう一度入力してください");
                continue;
            }else break;
        }

        // LocalDateTime now = LocalDateTime.now();
        // String pointDelDate = String.format("%04d-%02d-%02d",
        // now.getYear()+1,
        // now.getMonthValue(),
        // now.getDayOfMonth()); //ポイント期限
        int pointDelDate = new SystemDate().setPointDelDate();

        String pw = new Password().setPassword(); //パスワードランダム生成
       
        Student s = new Student();
        s.setStudentId(StudentId);
        s.setName(studentName);
        s.setPw(pw);
        s.setToeic(isToeic);
        s.setTeacherId(teacherId);
        s.setPoint(point);
        s.setPointDelDate(pointDelDate);
        s.setCourse(course);
        App.studentList.add(s);
        App.saveStudent();
        System.out.println("学生:" + StudentId + ", " + studentName + "さんが入会完了です、初期パスワードは:" + pw + ", パスワードは大事に保管してください");




}

    private String createStudentId() {
        String ID = "";
        LocalDateTime now = LocalDateTime.now();
        ID = ("s"+now.getYear()+ (0000 + App.studentList.size()));




        return ID;
    }


    private String createStudentPw() {
        String pw = "";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }
        pw = sb.toString();
        return pw;
    }

}
