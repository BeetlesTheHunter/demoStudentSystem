import java.util.Scanner;
public class Login {
    
    public void loginScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("IDを入力してください。");
        String userID = sc.nextLine();
        System.out.println("パスワードを入力してください。");
        String userPass = sc.nextLine();
        sc.close();//リソースの解放のためにあります。

        if(checkUser(userID,userPass)){

        }
    }

    private boolean checkUser(String _ID, String _pass){

        if(!_ID.equals("Testword")) return false;
        if(!_pass.equals("Testword")) return false;
        return  true;
    }
}
