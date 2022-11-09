package DAO;

import Model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static Connection connection = Connect_MySql.getConnect();

    public static List<Student> getAllStudent() {
        String sql = "Select * from student";
        List<Student> students = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idStudent = resultSet.getInt("idStudent");
                String name = resultSet.getString("Name");
                LocalDate dateOfBirth = resultSet.getDate("DateofBirth").toLocalDate();
                String address = resultSet.getString("Address");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String email = resultSet.getString("Email");
                int classroom = resultSet.getInt("idClassroom");
                students.add(new Student(idStudent, name, dateOfBirth, address, phoneNumber, email, classroom));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    public static List<Student> getStudent(String nameStudent) {
        String search = "%"+ nameStudent + "%";
        List<Student> students = new ArrayList<>();
        String sql = "Select * from student where Name LIKE ? ";

        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, search);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idStudent = resultSet.getInt("idStudent");
                String name = resultSet.getString("Name");
                LocalDate dateOfBirth = resultSet.getDate("DateofBirth").toLocalDate();
                String address = resultSet.getString("Address");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String email = resultSet.getString("Email");
                int classroom = resultSet.getInt("idClassroom");
                students.add(new Student(idStudent, name, dateOfBirth, address, phoneNumber, email, classroom));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    public static void save(Student student) {
        try {
            String sql = "insert into student(Name ,DateofBirth ,Address,PhoneNumber, Email, idClassroom) value ( ?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassroom());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void update(Student student) {
        try {
            String sql = "update student set Name = ? ,DateofBirth = ? ,Address = ?,PhoneNumber = ?, Email = ?, idClassroom = ? where idStudent = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassroom());
            preparedStatement.setInt(7, student.getIdStudent());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteUser(int idStudent) {
        try {
            String sql = "DELETE FROM student WHERE idStudent = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idStudent);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
