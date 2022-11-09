package Service;

import DAO.StudentDao;
import Model.Student;

public class StudentService {
    public static Student returnStudent(int idStudent) {
        Student student = null;
        for (Student s : StudentDao.getAllStudent()) {
            if (s.getIdStudent() == idStudent) {
                student = s;
            }
        }
        return student;
    }
}
