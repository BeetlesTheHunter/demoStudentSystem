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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Teacher{");
        sb.append("teacherId=").append(teacherId);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
}
