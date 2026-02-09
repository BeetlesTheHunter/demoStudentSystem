package Features;

import Objects.Reservation;

public class Booking {
    




    public void viewReservation(String id){//予約確認(二つに分けたけど分けんでもよかったわ)
        char firstChar =id.charAt(0);
        if(firstChar=="s"){
            //生徒用
            Boolean flag=false;
            for(int i=0;i<reservationList.size();i++){
                Reservation r =reservationList.get(i);
                flag=true;
                if((r.getStudentId()).equals(id)){
                    System.out.println(r.getDate()+" "+r.getTime());
                }
            }
            if(!flag){
                System.out.println("予約はありません。");
            }
            System.out.println();
            return;
        }
        if(firstChar=="t"){
            //教師用
            Boolean flag=false;
            for(int i=0;i<reservationList.size();i++){
                Reservation r =reservationList.get(i);
                flag=true;
                if((r.getStudentId()).equals(id)){
                    System.out.println(r.getDate()+" "+r.getTime());
                }
            }
            if(!flag){
                System.out.println("予約はありません。");
            }
            System.out.println();
            return;
        }


    }



}
