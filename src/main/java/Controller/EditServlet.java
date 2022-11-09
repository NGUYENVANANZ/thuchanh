package Controller;

import DAO.ClassDao;
import DAO.StudentDao;
import Model.Student;
import Model.StudentClass;
import Service.ClassService;
import Service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "EditControllor", value = "/EditControllor")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idStudent = Integer.parseInt(request.getParameter("id"));
        Student student = StudentService.returnStudent(idStudent);
        request.setAttribute("student", student);

        String nameClass = ClassService.nameClass(student.getClassroom());
        request.setAttribute("classname", nameClass);

        List<StudentClass> studentClasses = ClassDao.getAllClass();
        request.setAttribute("listClass", studentClasses);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EditStudent.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int idclass = Integer.parseInt(request.getParameter("idClassRoom"));

        Student student = new Student(id, name, date, address, phone, email, idclass);
        StudentDao.update(student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ShowStuden_Servlet");
        requestDispatcher.forward(request, response);
    }
}
