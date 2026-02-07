public class Student implements ClassCourse{
    private String studentId;
    private String name;
    private String pw;
    private boolean toeic;
    private String teacherId;
    private int point;
    private String pointDelDate;
    private Course course;

    public Student() {
    }

    public Student(String studentId, String name, String pw, boolean toeic, String teacherId, int point, String pointDelDate, String course){
        this.studentId = studentId;
        this.name = name;
        this.pw = pw;
        this.toeic = toeic;
        this.teacherId = teacherId;
        this.point = point;
        this.pointDelDate = pointDelDate;
        setCourse(course);      
    }

    //methods
    
    public String pointsprint(){
        if(point < App.globalPointMin){
            return "ポイントが足りませ購入してください。";
        }else{
            return (this.point+"");
        }
    }

    //getter setters 
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }

    public boolean isToeic() {
        return toeic;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public int getPoint() {
        return point;
    }

    public String getPointDelDate() {
        return pointDelDate;
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setToeic(boolean toeic) {
        this.toeic = toeic;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setPointDelDate(String pointDelDate) {
        this.pointDelDate = pointDelDate;
    }

    public void setCourse(String _course){
        switch (_course) {
           case "low" -> course = Course.LOW;
           case "upper" -> course = Course.UPPER;
           case "high" -> course = Course.HIGH;
        }
    }

    public String getCourse(){
        return course.getCourseString();
    }

    public Course getClassCourse(){
        return this.course;
    }
}
