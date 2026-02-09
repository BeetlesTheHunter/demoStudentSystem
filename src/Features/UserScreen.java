 package Features;
 
import Objects.Student;
import java.util.Scanner;
import main.App;

public class UserScreen {

    private static Scanner sc = new Scanner(System.in);
    private static Student s;

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
            System.out.println("3.ポイント購入");
            System.out.println("4.パスワード変更");
            System.out.println("5.ログアウト");
            System.out.println("6.システム終了");


            String choice = sc.nextLine();


            switch (choice){
                case "1" -> System.out.println();
                case "2" -> System.out.println();
                case "3" -> new BuyPoint().buyPointScreen(USER.getStudentId());
                case "4" -> new Password().changePw(USER.getStudentId());
                case "5" -> {return;}
                case "6" -> System.exit(0);
                default -> System.out.println("Not an option try again");
            }
        }
       
    }
  
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
            System.out.println("4.ログアウト");
            System.out.println("5.システム終了");


            String choice = sc.nextLine();


            switch (choice){
                case "1" -> setTarget();
                case "2" -> new AddStudent().addStudentScreen();
                case "3" -> viewStudent();
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

    private static void setTarget(){
        System.out.println("生徒IDを入力してください。");
        s = App.findStudent(sc.nextLine());
        if(s == null)System.out.println("Not a Student!!");
    }

    public void viewStudent(){//テスト用
        System.out.println(App.studentList.size());
        for (int i = 0; i < App.studentList.size(); i++) {
            System.out.println(App.studentList.get(i).toString());
        }
    }
    
    
}

