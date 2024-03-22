package control;

import dao.TeacherDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student ID to be deleted from the request parameter
    	String teacherCodeParam = request.getParameter("code");

        if (teacherCodeParam != null) {
            try {
                int teacherCode = Integer.parseInt(teacherCodeParam);

                // Use the StudentDAO to delete the student
                TeacherDAO teacherDAO = new TeacherDAO();
                boolean deleted = teacherDAO.deleteTeacher(teacherCode);

                if (deleted) {
                    // Redirect to a success page or list of students
                    response.sendRedirect(request.getContextPath() + "/ListTeachersServlet");
                } 
            } catch (NumberFormatException e) {
                // Handle the case when the student ID parameter is not a valid number
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } 
    }
}
