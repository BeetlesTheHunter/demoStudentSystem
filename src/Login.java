import java.util.InputMismatchException;
import java.util.Scanner;
public class Login {
    
    public void loginScreen(){
        String userID = null;
        String userPass = null;


        // ループすとこわれる
        //色々試したがwhile文でもこわれます。
        /*
            Exception in thread "main" java.util.NoSuchElementException: No line found
            at java.base/java.util.Scanner.nextLine(Scanner.java:1690)
            at Login.loginScreen(Login.java:13)
            at Login.loginScreen(Login.java:26)
            at App.main(App.java:19)    
        */
       Scanner sc = new Scanner(System.in);

        try{
            System.out.println("IDを入力してください。");
            userID = sc.nextLine();
            System.out.println("パスワードを入力してください。");
            userPass = sc.nextLine();
        }catch(InputMismatchException e){
            System.err.println(e.getMessage());
        }

        if(checkUser(userID,userPass)){
            studentScreen(userID);
        }else{
            System.out.println("IDかパスワードが間違ってます。");
        }

        loginScreen();
    }

    private boolean checkUser(String _ID, String _pass){
        Student user = App.findStudent(_ID);
        if(user == null)return false;
        if(!user.getStudentId().equals(_ID))return false;
        if(!user.getPw().equals(_pass))return false;
        
        return true;
    }

    private void studentScreen(String _ID){
        final Student USER = App.findStudent(_ID);
        System.out.println(USER.getName());

    }
}
