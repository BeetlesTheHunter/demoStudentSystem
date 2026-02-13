package Features;
import Objects.Student;
import java.util.Scanner;
import main.App;
import main.SystemDate;

public class ManageStudent {
    private static Student s;
    static Scanner sc = new Scanner(System.in);
    public void manageStudentScreen(){//管理者用生徒管理画面

        System.out.println("--------生徒管理システム--------"); 
        setTarget();      
        while (true) {
            System.out.println("対象生徒: " + s.getName() + " (ID: " + s.getStudentId() + ")");
            System.out.println("***変更が完了したら必ず5を押して保存してください***");
            System.out.println("[1]: 名前変更");
            System.out.println("[2]: コース変更");
            System.out.println("[3]: パスワード変更");
            System.out.println("[4]: ポイント確認・変更");
            System.out.println("[5]: 変更完了/前のページに戻ります");
            String choose = sc.nextLine();
            switch (choose) {
                case "1" -> changeName(s);
                    
                case "2" -> changeCourse(s);

                case "3" -> s.setPw(new Password().setPassword());

                case "4" -> pointScreen(s);

                case "5" -> {App.saveStudent();
                            return;
                }

                default -> System.out.println("もう一度入力してください");

            }
        }
}

    private void changeCourse(Student s) {//コース変更
        String newCourse = "";
        while (true) { //コース選択
            System.out.println("コースを選択(low,upper,high)");
            newCourse = sc.nextLine();    //コース選択
            if(!(newCourse.equals("low") || newCourse.equals("upper") || newCourse.equals("high"))){
                System.out.println("入力ミス、もう一度入力してください");
                continue;
            }else break;
        }
        s.setCourse(newCourse);
        // App.saveStudent();
        System.out.println("コースが " + newCourse + " に変更されました。");
    }

    private void changeName(Student s) {//名前変更
        System.out.println("新しい名前を入力してください:");
        String newName = sc.nextLine();
        s.setName(newName);
        // App.saveStudent();
        System.out.println("名前が " + newName + " に変更されました。");
    }

    private void pointScreen(Student s) {//ポイント確認・変更画面
        System.out.println("現在のポイント: " + s.getPoint());
        System.out.println("ポイントを変更しますか？ (y/n)");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")){
            System.out.println("新しいポイント数を入力してください: (ポイントは200ポイント以上、200ポイントごとにしか変更できません)");
            int newPoints = sc.nextInt();
            sc.nextLine();
            if(newPoints % 200 != 0 || newPoints < 200){
                System.out.println("入力されたポイント数は無効です。");
                return;
            }
            s.setPoint(newPoints);
            s.setPointDelDate(new SystemDate().setPointDelDate());
            // App.saveStudent();
            System.out.println("ポイントが " + newPoints + " に変更されました。");
        } else {
            System.out.println("ポイント変更をキャンセルしました。");
        }
    }

    private static void setTarget(){//対象生徒設定
        System.out.println("生徒IDを入力してください。");
        s = App.findStudent(sc.nextLine());
        if(s == null)System.out.println("Not a Student!!");
    }
}
