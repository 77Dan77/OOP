import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itse?serverTimezone=UTC","root","");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addStudent(Student student){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `student`(`id`, `name`, `surname`, `faculty`, `groups`) VALUES (NULL, ?,?,?,?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getFaculty());
            statement.setString(4, student.getGroup());

            statement.executeUpdate(); /////  UPDATE, INSERT, DELETE
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Student> selectAllStudents(){
        ArrayList<Student> listFromDB = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `student` ");
            ResultSet table =  statement.executeQuery();//// SELECT

            while(table.next()){
                Long id = table.getLong("id");
                String name = table.getString("name");
                String surname = table.getString("surname");
                String faculty = table.getString("faculty");
                String group = table.getString("groups");

                listFromDB.add(new Student(id, name, surname, faculty, group));
            }
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return  listFromDB;
    }

    public void deleteStudent(Long studentID){
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `student` WHERE id = ?");
            statement.setLong(1, studentID);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
