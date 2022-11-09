package Controller;

import DAO.StudentDao;
import Model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "ShowStuden_Servlet", value = "/ShowStuden_Servlet")
public class ShowStuden_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = StudentDao.getAllStudent();
        request.setAttribute("Student", students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ShowStudent.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = StudentDao.getAllStudent();
        request.setAttribute("Student", students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ShowStudent.jsp");
        requestDispatcher.forward(request, response);

    }
}
