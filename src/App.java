import java.util.ArrayList;
import java.util.HashMap;

public class App {
    private static ArrayList<Student> studentList = new ArrayList<Student>();
    private static HashMap<String,Student> studentMap = new HashMap<String,Student>();

    public static void main(String[] args) throws Exception {
        Login l = new Login();
        l.loginScreen();
    }

    public static void makeStudentMap(){//ロード関数にこれを追加してください。
        for (int i = 0; i < studentList.size(); i++){
            studentMap.put(studentList.get(i).getStudentId(), studentList.get(i));
        }
    }
    public static Student findStudent(String _ID){
        return studentMap.get(_ID); //Student のリストからIDで探します。
    }
}
