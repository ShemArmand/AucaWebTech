package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAO;
import model.Student;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(studentId);

        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("/editStudent.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("id"));
        String regNo = request.getParameter("regNo");
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(studentId);

        if (student != null) {
            student.setRegNo(regNo);
            student.setName(name);
            student.setDateOfBirth(dateOfBirth);

            studentDAO.saveOrUpdate(student);
            response.sendRedirect(request.getContextPath() + "/ListStudentsServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
