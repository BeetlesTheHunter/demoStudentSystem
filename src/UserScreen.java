import java.time.LocalDateTime;
import java.util.Scanner;

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
            System.out.println("4.");
            System.out.println("5.");

            String choice = sc.nextLine();

            switch (choice){
                case "1" -> System.out.println();
                case "2" -> System.out.println();
                case "3" -> System.out.println();
                case "4" -> System.out.println();
                case "5" -> System.out.println();
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
            System.out.println("2.");
            System.out.println("3.");
            System.out.println("4.");
            System.out.println("5.");

            String choice = sc.nextLine();

            switch (choice){
                case "1" -> setTarget();
                case "2" -> System.out.println();
                case "3" -> System.out.println();
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
            String choose = sc.next();
            switch (choose) {
                case "1" :
                    System.out.println("入会手続きを開始します");
                    addStudent();
                    continue;
                case "2" :
                     System.out.println("システム終了します"); System.exit(0);
                default :
                 System.out.println("もう一度入力してください");
                 continue;
            }
        }

    }

    private void addStudent(){
        String StudentId = createStudentId();//未作成
        System.out.println("生徒名を入力してください");
        String studentName = sc.next();
        System.out.println("Toeicを選択しますか? y/n");
        String toeic = sc.next();
        boolean isToeic = toeic.equalsIgnoreCase("y");
        System.out.println("担当したい教師IDを入力 例:t001");
        String teacherId = sc.next();
        while (true) { //ポイント購入チェック
            System.out.println("購入するポイントを入力 (購入条件は最低限200ポイントおよび200ポイントごとしか買えない)");
            int point = sc.nextInt();
            if(!checkBuyPoint(point)){
                continue;
            }else break;
}
        LocalDateTime now = LocalDateTime.now();
        String pointDelDate = String.format("%04d-%02d-%02d",
        now.getYear(),
        now.getMonthValue(),
        now.getDayOfMonth());

}

    private String createStudentId() {
        return "";
    }

    private boolean checkBuyPoint(int point) {
        if(point<200){return false;}
        if(point%200!=0){return false;}
        return true;
    }


}
