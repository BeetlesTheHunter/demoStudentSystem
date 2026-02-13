package Features;

import Objects.Teacher;
import main.App;
import main.SystemDate; 
import java.util.Scanner;

public class AddTeacher {
    private String ID;
    private String name;
    private String password;

    private static Scanner sc = new Scanner(System.in);

    public void addTeacher(){
        while (true){
            this.ID = "t" + main.SystemDate.getYear() + (App.teacherList.size() + 1);
            System.out.println("名前を入力してください。");
            this.name = sc.nextLine();
            this.password = new Password().setPassword();
            
            System.out.println(this.name);
            System.out.println("よろしいいですか。");

            System.out.println("1.はい");
            System.out.println("2.いいえ");
            if(sc.nextLine().equals("1"))break;
        }

        Teacher t = new Teacher();

        t.setTeacherId(this.ID);
        t.setName(this.name);
        t.setPassword(this.password);

        App.teacherList.add(t);
        App.saveTeacher();
    }
    
}
