package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

@WebServlet("/ListStudentsServlet")
public class ListStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            // Handle viewing a single student for editing
            int studentId = Integer.parseInt(request.getParameter("id"));
            StudentDAO studentDAO = new StudentDAO();
            Student student = studentDAO.getStudentById(studentId);

            if (student != null) {
                request.setAttribute("student", student);
                request.getRequestDispatcher("/editStudent.jsp").forward(request, response);
            } else {
                // Handle the case when the student is not found (e.g., show an error page)
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // List all students
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = studentDAO.getAllStudents();

            request.setAttribute("students", students);
            request.getRequestDispatcher("/allStudents.jsp").forward(request, response);
        }
    }
}
