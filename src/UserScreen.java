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
}
