package Objects;

public class Reservation {
    private String studentId;
    private String teacherId;
    private String date;
    private String time;
    private String type;

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

    public String getType(){
        return this.type;
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

    public void setType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation{");
        sb.append("studentId=").append(studentId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }


}