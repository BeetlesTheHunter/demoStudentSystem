 package Features;
 
import Objects.Student;
import java.util.Scanner;
import main.App;

public class UserScreen {

    private static Scanner sc = new Scanner(System.in);
    private static Student s;

    public void studentScreen(String _ID){//生徒画面
        final Student USER = App.findStudent(_ID);
        // System.out.println(USER.getName());
        // System.out.println(USER.getPoint());


        while(true){
            System.out.println("=====================池田英会話スクール=====================");
            System.out.println("ID: " + USER.getStudentId());
            System.out.println("名前: " + USER.getName());
            System.out.println("コース: " + USER.getCourse());
            System.out.println("ポイント残高: " + USER.getPoint());      
            System.out.println("");
           
            System.out.println("[1].予約確認");
            System.out.println("[2].予約");
            System.out.println("[3].ポイント購入");
            System.out.println("[4].パスワード変更");
            System.out.println("[5].ログアウト");
            System.out.println("[6].システム終了");
            


            String choice = sc.nextLine();


            switch (choice){
                case "1" -> new Booking().viewReservation(USER.getStudentId());
                case "2" -> System.out.println();
                case "3" -> new BuyPoint().buyPointScreen(USER.getStudentId());
                case "4" -> USER.setPw(new Password().setPassword());
                case "5" -> {
                    System.out.println("ログアウトしました");
                    return;}
                case "6" -> {
                    System.out.println("システム終了します");
                    System.exit(0);
                            }
                default -> System.out.println("Not an option try again");
            }
        }
       
    }
  
    public void adminScreen(){//管理者画面
        while(true){
            System.out.println("=============================管理者画面=============================");
            System.out.println("注意：管理者モードです。");
            if(s != null){
                System.out.println("対象：" + s.getName());
            }
           
            System.out.println("");
            System.out.println("[1].学生入会");
            System.out.println("[2].生徒一覧"); //テスト、デバッグ用
            System.out.println("[3].生徒管理");
            System.out.println("[4].ログアウト");
            System.out.println("[5].システム終了");


            String choice = sc.nextLine();


            switch (choice){
                case "1" -> new AddStudent().addStudentScreen();
                case "2" -> viewStudent();
                case "3" -> new ManageStudent().manageStudentScreen();
                             
                case "4" -> {
                    System.out.println("ログアウトしました");
                    return;
                            }
                case "5" -> {
                    System.out.println("システム終了します");
                    System.exit(0);
                            }
                default -> System.out.println("Not an option try again");
            }
        }
    }

    public void viewStudent(){//デバッグ用生徒一覧表示
        System.out.println(App.studentList.size());
        for (int i = 0; i < App.studentList.size(); i++) {
            System.out.println(App.studentList.get(i).toString());
        }
    }
    
    
}

