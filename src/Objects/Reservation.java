package Objects;

public class Reservation {
    private String studentId;
    private String teacherId;
    private String date;
    private String time;

    public String getStudentId(){
        return this.studentId;
    }

    public String getTeacherId(){
        return this.teacherId;
    }

    public String getDate(){
        return this.date;
    }

    public String getTime(){
        return this.time;
    }

    public void setStudentId(String sId){
        this.studentId=sId;
    }

    public void setTeacherId(String tId){
        this.teacherId=tId;
    }

    public void setDate(String date){
        this.date=date;
    }

    public void setTime(String time){
        this.time=time;
    }


}