package Features;
import java.util.Scanner;
import main.App;
import main.SystemDate;

public class BuyPoint {
    static Scanner sc = new Scanner(System.in);
    public void buyPointScreen(String id){//ポイント購入画面
        int point = 0;

        while (true) { //ポイント購入チェック
            System.out.println("購入するポイントを入力してください (購入条件は最低限200ポイントおよび200ポイントごとしか買えない)");
            point = sc.nextInt();
            sc.nextLine();
            if(!checkBuyPoint(point)){
                System.out.println("購入条件に合わないです、もう一度入力してください");
                continue;
            }else {
                break;
            }
        }
        System.out.println("-------購入確認--------");
        System.out.println("生徒名:" + App.findStudent(id).getName());
        System.out.println("ポイント残高:" + App.findStudent(id).getPoint());
        System.out.println("購入ポイント:" + point);
        System.out.println("金額:" + point*1000 + "円");
        System.out.println("");
        System.out.println("クレジットカード情報を入力してください");
        System.out.println("カード番号(16桁):");
        String cNumber = sc.next();
        while (true) { //カード番号チェック
            if(!checkCnumber(cNumber)){
                System.out.println("カード番号が不正です。");
                continue;
            }else{
                break;
            }
}
        System.out.println("カード名義：");
        sc.next();
        System.out.println("有効期限：");
        sc.next();
        System.out.println("セキュリティコード：");
        int csc =sc.nextInt();
        while (true) { //セキュリティコードチェック
            if(!checkCsecurityCode(csc)){
                System.out.println("セキュリティコードが不正です。");
                continue;
            }else{
                System.out.println("セキュリティコード確認完了");
                break;
            }
        }
        System.out.println("購入を確定しますか？ y/n");
        String choose = sc.next();
   
        int pointDelDate = SystemDate.setPointDelDate();
        if(choose.equalsIgnoreCase("y")){
            for (int i = 0; i < App.studentList.size(); i++) {
                if(id.equals(App.studentList.get(i).getStudentId())){
                    int oldPoint = App.studentList.get(i).getPoint();
                    App.studentList.get(i).setPoint(oldPoint + point);
                    App.studentList.get(i).setPointDelDate(pointDelDate);
                }       
            }
            
            App.saveStudent();
            System.out.println("決済中...");
            try {   
            Thread.sleep(2000);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
            System.out.println("ポイント購入完了しました。");
        }else{
            System.out.println("ポイント購入をキャンセルしました。");
            buyPointScreen(id);
    }
}
    
    private boolean checkCnumber(String cNumber) {//カード番号チェック
        if(cNumber.length() != 16){return false;}
        return true;
    }

    public boolean checkBuyPoint(int point) {//ポイント購入条件チェック
        if(point<200){return false;}
        if(point%200!=0){return false;}
        return true;
    }

    private boolean checkCsecurityCode(int csc) {//セキュリティコードチェック
        if(csc < 100 || csc > 999){return false;}
        return true;
    }

    
}
