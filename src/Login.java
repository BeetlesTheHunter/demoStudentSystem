import java.util.Scanner;
public class Login {
    
    public void loginScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("IDを入力してください。");
        String userID = sc.nextLine();
        System.out.println("パスワードを入力してください。");
        String userPass = sc.nextLine();
        sc.close();//リソースの解放のためにあります。

        if(checkUser(userID,userPass))studentScreen(userID);
    }

    private boolean checkUser(String _ID, String _pass){

        if(!_ID.equals("")) return false;
        if(!_pass.equals("")) return false;
        return  true;
    }

    private void studentScreen(String _ID){
        System.out.println("Youre in");

        final Student USER = App.findStudent(_ID);
        System.out.println(USER.getName());

    }
}
