package Features;
import Objects.Student;
import Objects.Teacher;
import java.util.InputMismatchException;
import java.util.Scanner;
import main.App;

public class Login {
    public static Scanner sc = new Scanner(System.in);
    
    public void loginScreen(){
        String userID = null;
        String userPass = null;

        try{
            System.out.println("IDを入力してください。");
            userID = sc.nextLine();
            System.out.println("パスワードを入力してください。");
            userPass = sc.nextLine();
        }catch(InputMismatchException e){
            System.err.println(e.getMessage());
        }

        if(checkStudent(userID,userPass)){
            new UserScreen().studentScreen(userID);
        }else if(){

        }else if(checkAdmin(userID,userPass)){
            new UserScreen().adminScreen();
        }else{
            System.out.println("IDかパスワードが間違ってます。");
        }

        loginScreen();
    }

    private boolean checkAdmin(String _ID, String _pass){
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
