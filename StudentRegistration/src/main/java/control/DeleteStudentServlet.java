package control;

import dao.StudentDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student ID to be deleted from the request parameter
        String studentIdParam = request.getParameter("id");

        if (studentIdParam != null) {
            try {
                int studentId = Integer.parseInt(studentIdParam);

                // Use the StudentDAO to delete the student
                StudentDAO studentDAO = new StudentDAO();
                boolean deleted = studentDAO.deleteStudent(studentId);

                if (deleted) {
                    // Redirect to a success page or list of students
                    response.sendRedirect(request.getContextPath() + "/ListStudentsServlet");
                } else {
                    // Handle the case when the student cannot be deleted (e.g., show an error page)
                    response.sendRedirect(request.getContextPath() + "/error.jsp");
                }
            } catch (NumberFormatException e) {
                // Handle the case when the student ID parameter is not a valid number
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // Handle the case when no student ID parameter is provided
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
