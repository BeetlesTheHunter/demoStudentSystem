import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;


public class UserScreen {

    private static Scanner sc = new Scanner(System.in);

    public void studentScreen(String _ID){
        final Student USER = App.findStudent(_ID);
        System.out.println(USER.getName());
        System.out.println(USER.getPoint());


        while(true){
            System.out.println("=======生徒画面=====================================");
            System.out.println(USER.getName());
            System.out.println(USER.getCourse());
            System.out.println(USER.pointsprint());
            System.out.println("");
           
            System.out.println("1.");
            System.out.println("2.");
            System.out.println("3.");
            System.out.println("4.パスワード変更");
            System.out.println("5.ログアウト");


            String choice = sc.nextLine();


            switch (choice){
                case "1" -> System.out.println();
                case "2" -> System.out.println();
                case "3" -> System.out.println();
                case "4" -> changePw(USER.getStudentId());
                case "5" -> new Login().loginScreen();
                default -> System.out.println("Not an option try again");
            }
        }
       
    }

    private static Student s;
    public void adminScreen(){


        while(true){
            System.out.println("=======管理者画面=====================================");
            System.out.println("注意：管理者モードです。");
            if(s != null){
                System.out.println("対象：" + s.getName());
            }
           
            System.out.println("");
            System.out.println("1.Set Student");
            System.out.println("2.学生入会");
            System.out.println("3.生徒一覧"); //テスト、デバッグ用
            System.out.println("4.");
            System.out.println("5.");


            String choice = sc.nextLine();


            switch (choice){
                case "1" -> setTarget();
                case "2" -> addStudentScreen();
                case "3" -> viewStudent();
                case "4" -> System.out.println();
                case "5" -> System.out.println();
                default -> System.out.println("Not an option try again");
            }
        }
    }

    private void setTarget(){
        System.out.println("生徒IDを入力してください。");
        s = App.findStudent(sc.nextLine());
        if(s == null)System.out.println("Not a Student!!");
    }

    private void addStudentScreen(){
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
                    new Login().loginScreen();
                case "4" :
                    adminScreen();
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
            if(!checkBuyPoint(point)){
                System.out.println("正しくないポイント数です、もう一度入力してください");
                continue;
            }else break;
        }

        String course = "null";
        while (true) { //コース選択
            System.out.println("コースを選択(low,upper,high)");
            course = sc.next();    //コース選択
            if(!(course.equals("low") || course.equals("upper") || course.equals("high"))){
                System.out.println("入力ミス、もう一度入力してください");
                continue;
            }else break;
        }

        LocalDateTime now = LocalDateTime.now();
        String pointDelDate = String.format("%04d-%02d-%02d",
        now.getYear()+1,
        now.getMonthValue(),
        now.getDayOfMonth()); //ポイント期限

        String pw = createStudentPw(); //パスワードランダム生成
       
        try(FileWriter fw = new FileWriter("student.csv", true)){
            StringJoiner sj = new StringJoiner(",");
            String student = sj.add(StudentId)
            .add(studentName)
            .add(pw)
            .add(String.valueOf(isToeic))
            .add(teacherId)
            .add(String.valueOf(point))
            .add(pointDelDate)
            .add(String.valueOf(course))
            .toString();
            fw.write(student); 
            fw.write("\n"); 
        } catch (Exception e) {
            e.getStackTrace();
        }


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
        App.loadStudent();
        System.out.println("学生:" + StudentId + ", " + studentName + "さんが入会完了です、初期パスワードは:" + pw + ", パスワードは大事に保管してください");




}

    private String createStudentId() {
        String ID = "";
        LocalDateTime now = LocalDateTime.now();
        ID = ("s"+now.getYear()+ (0000 + App.studentList.size()));




        return ID;
    }

    private boolean checkBuyPoint(int point) {
        if(point<200){return false;}
        if(point%200!=0){return false;}
        return true;
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

    private void viewStudent(){//テスト用
        System.out.println(App.studentList.size());
        for (int i = 0; i < App.studentList.size(); i++) {
            System.out.println(App.studentList.get(i).toString());
        }
    }

    private void changePw(String Id){
    String pw;
    while (true) { 
            System.out.println("変えたいパスワードを入力してください");
            System.out.println("パスワードは6文字以上12文字以下、英数字のみ使用可能");
            pw = sc.next();
            if(!checkPw(pw)){
                System.out.println("パスワードが条件に合わないです、もう一度入力してください");
                continue;
            }else {
                System.out.println("入力したパスワードをもう一度確認してください");
                String againPw = sc.next();
                if(!againPw.equals(pw))continue;
                else{
                    System.out.println("パスワード変更成功");
                    break;
                }
            }
        }
    for (int i = 0; i < App.studentList.size(); i++) {
        if(Id.equals(App.studentList.get(i).getStudentId())){
            App.studentList.get(i).setPw(pw);
        }       
    }
    try(FileWriter fw = new FileWriter("student.csv")) {
        for(Student s : App.studentList){
            fw.write(s.getStudentId() + "," +
                     s.getName() + "," +
                     s.getPw() + "," +
                     s.isToeic() + "," +
                     s.getTeacherId() + "," +
                     s.getPoint() + "," +
                     s.getPointDelDate() + "," +
                     s.getCourse() + "," + "\n");                   
        }fw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    private boolean checkPw(String pw) {
        if(pw.length()<6 || pw.length()>12){return false;}
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if(!((c>='a' && c <= 'z') || (c>='A' && c <= 'Z') || (c>='0' && c<='9'))){return false;}
        }


        return true;
    }
    
    
}

