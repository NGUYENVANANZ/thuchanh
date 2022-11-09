package Controller;

import DAO.ClassDao;
import DAO.StudentDao;
import Model.Student;
import Model.StudentClass;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "AddStudentServlet", value = "/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StudentClass> studentClasses = ClassDao.getAllClass();
        request.setAttribute("listClass", studentClasses);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AddStudent.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int idclass = Integer.parseInt(request.getParameter("idClassRoom"));

        Student student = new Student(name, date, address, phone, email, idclass);
        StudentDao.save(student);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ShowStuden_Servlet");
        requestDispatcher.forward(request, response);
    }
}
