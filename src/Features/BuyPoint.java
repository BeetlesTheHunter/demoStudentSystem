package Features;
import main.App;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BuyPoint {
    static Scanner sc = new Scanner(System.in);
    public void buyPointScreen(String id){
        int point = 0;

        while (true) { //ポイント購入チェック
            System.out.println("購入するポイントを入力してください (購入条件は最低限200ポイントおよび200ポイントごとしか買えない)");
            point = sc.nextInt();
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
                System.out.println("カード番号確認完了");
                break;
            }
}
        System.out.println("カード名義：");
        String cName = sc.next();
        System.out.println("有効期限：");
        sc.next();
        System.out.println("セキュリティコード：");
        sc.next();
        System.out.println("購入を確定しますか？ y/n");
        String choose = sc.next();
        LocalDateTime now = LocalDateTime.now();
        String pointDelDate = String.format("%04d-%02d-%02d",
        now.getYear()+1,
        now.getMonthValue(),
        now.getDayOfMonth()); 
        if(choose.equalsIgnoreCase("y")){
            for (int i = 0; i < App.studentList.size(); i++) {
                if(id.equals(App.studentList.get(i).getStudentId())){
                    int oldPoint = App.studentList.get(i).getPoint();
                    App.studentList.get(i).setPoint(oldPoint + point);
                    App.studentList.get(i).setPointDelDate(pointDelDate);
                }       
            }
            
            App.saveStudent();
            System.out.println("ポイント購入完了しました。");
        }else{
            System.out.println("ポイント購入をキャンセルしました。");
            buyPointScreen(id);
    }
}
    

    private boolean checkCnumber(String cNumber) {
        if(cNumber.length() != 16){return false;}
        return true;
    }

    public boolean checkBuyPoint(int point) {
        if(point<200){return false;}
        if(point%200!=0){return false;}
        return true;
    }

    
}
