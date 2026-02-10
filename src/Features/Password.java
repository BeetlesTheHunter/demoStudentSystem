package Features;
import main.App;

public class Password {
    static java.util.Scanner sc = new java.util.Scanner(System.in);

    public String setPassword(){//パスワード設定画面

        String password;
        while (true) {
            System.out.println("新しいパスワードを入力してください");
            System.out.println("パスワードは6文字以上12文字以下、英数字のみ使用可能");
            password = sc.nextLine();

            if(!checkPw(password)){
                System.out.println("パスワードが条件に合わないです、もう一度入力してください");
                continue;
            }

            System.out.println("入力したパスワードをもう一度確認してください");
            String againPw = sc.next();
            if(!againPw.equals(password))continue;
            System.out.println("パスワードは" + password + " です。メモしてください。");

            break;
        }       

        return ((Integer)password.hashCode()).toString();
    }

    public static void changePw(String Id){//パスワード変更画面
        String pw;
        while (true) { 
                System.out.println("変えたいパスワードを入力してください");
                System.out.println("パスワードは6文字以上12文字以下、英数字のみ使用可能");
                pw = sc.nextLine();
                if(!checkPw(pw)){
                    System.out.println("パスワードが条件に合わないです、もう一度入力してください");
                    continue;
                }else {
                    System.out.println("入力したパスワードをもう一度確認してください");
                    String againPw = sc.nextLine();
                    if(!againPw.equals(pw))continue;
                    else{
                        System.out.println("パスワード変更成功");
                        break;
                    }
                }
            }
        for (int i = 0; i < App.studentList.size(); i++) {
            if(Id.equals(App.studentList.get(i).getStudentId())){
                App.studentList.get(i).setPw(pw);
            }       
        }
        App.saveStudent();
    }

    public static boolean checkPw(String pw) {//パスワードの条件チェック
        if(pw.length()<6 || pw.length()>12){return false;}
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if(!((c>='a' && c <= 'z') || (c>='A' && c <= 'Z') || (c>='0' && c<='9'))){return false;}
        }


        return true;
    }
}
