import java.util.InputMismatchException;
import java.util.Scanner;

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
        System.out.println(USER.getPoint());

        while(true){
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
}
