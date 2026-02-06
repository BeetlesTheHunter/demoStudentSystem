import java.util.Scanner;
public class login {
    
    public static void loginScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("IDを入力してください。");
        String userID = sc.nextLine();
        System.out.println("パスワードを入力してください。");
        String userPass = sc.nextLine();
        sc.close();//リソースの解放のためにあります。
    }

    private boolean checkUser(String _ID, String _pass){

        
        return  true;
    }
}
