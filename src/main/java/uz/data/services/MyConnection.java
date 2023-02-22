package uz.data.services;

import org.springframework.stereotype.Component;
import uz.data.model.Student;
import uz.data.repositories.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyConnection implements StudentRepository {
    private final String URL = "jdbc:mysql://localhost:3306/students";
    private final String USER = "root";
    private final String PASSWORD = "admin";


    @Override
    public List<Student> getAll() {
        List<Student> studentList=new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt=connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from students.student");
            while (resultSet.next()){
                studentList.add(new Student(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return studentList;

    }
    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public void update(Long id, String name, String phone, String email, String region, String district) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt=connection.createStatement();
            stmt.execute("update student set name='"+name+"',phone='"+phone+"',email='"+email+"',region='"+region+"',district='"+district+"' where id = "+id+";");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(Long id) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt=connection.createStatement();
            stmt.execute("DELETE FROM student WHERE id="+id+";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void save(String name, String phone, String email, String region, String district) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt=connection.createStatement();
            stmt.execute("insert into student(name,phone,email,region,district) values ('"+name+"','"+phone+"','"+email+"','"+region+"','"+district+"');");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
