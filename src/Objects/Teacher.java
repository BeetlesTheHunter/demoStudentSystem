package Objects;
public class Teacher {
    
    private String teacherId;
    private String name;
    private String password;

    //getter
    public String getTeacherId() {
        return this.teacherId;
    }
    public String getName() {
        return this.name;
    }

    //setter
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPw(){
        return this.password;
    }
}
