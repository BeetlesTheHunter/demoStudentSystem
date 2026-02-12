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

    public String getPw(){
        return this.password;
    }

    //setter
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
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
