package Features;
import Objects.Student;
import Objects.Teacher;
import java.util.InputMismatchException;
import java.util.Scanner;
import main.App;

public class Login {
    public static Scanner sc = new Scanner(System.in);
    
    public void loginScreen(){//ログイン画面
        String userID = null;
        String userPass = null;

        System.out.println("========================池田英会話スクールへようこそ========================");
        System.out.println("ログイン画面");
        System.out.println("");
        try{
            System.out.print("ID: ");
            userID = sc.nextLine();
            System.out.print("パスワード: ");
            userPass = sc.nextLine();
        }catch(InputMismatchException e){
            System.err.println(e.getMessage());
        }

        if(checkStudent(userID,userPass)){
            new UserScreen().studentScreen(userID);
        }else if(checkTeacher(userID,userPass)){

        }else if(checkAdmin(userID,userPass)){
            System.out.println("ログインしました");
            System.out.println("");
            new UserScreen().adminScreen();
        }else{
            System.out.println("IDかパスワードが間違ってます、もう一度ログインしてください。");
            System.out.println("");
        }

        loginScreen();
    }

    private boolean checkAdmin(String _ID, String _pass){//管理者チェック
        if(!_ID.equals("admin"))return false; //いつかTeacherに変えます
        if(!_pass.equals("admin"))return false;
        return true;
    }

    private boolean checkStudent(String _ID, String _pass){
        Student user = App.findStudent(_ID);
        String input = ((Integer)(_pass.hashCode())).toString();
        if(user == null)return false;
        if(!user.getStudentId().equals(_ID))return false;
        if(!user.getPw().equals(input))return false;
        
        return true;
    }

    private boolean checkTeacher(String _ID, String _pass){
        Teacher user = App.findTeacher(_ID);
        String input = ((Integer)(_pass.hashCode())).toString();
        if(user == null)return false;
        if(!user.getTeacherId().equals(_ID))return false;
        if(!user.getPw().equals(input))return false;
        
        return true;
    }

    
}
