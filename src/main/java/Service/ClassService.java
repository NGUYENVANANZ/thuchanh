package Service;

import DAO.ClassDao;
import Model.StudentClass;

public class ClassService {
    public static String nameClass(int idClass){
        for (StudentClass s : ClassDao.getAllClass()) {
            if (s.getIdClass() == idClass){
                return s.getNameClass();
            }
        }
        return "";
    }
}
