package DAO;

import Model.StudentClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassDao {
    public static List<StudentClass> getAllClass() {
        String sql = "Select * from classroom";
        List<StudentClass> studentClasses = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            Statement statement = StudentDao.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idClassroom = resultSet.getInt("idClassroom");
                String nameClass = resultSet.getString("nameClass");
                studentClasses.add(new StudentClass(idClassroom, nameClass));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentClasses;
    }
}
