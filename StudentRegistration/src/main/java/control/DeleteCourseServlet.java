package control;

import dao.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the course ID to be deleted from the request parameter
        String courseIdParam = request.getParameter("id");

        if (courseIdParam != null) {
            try {
                int courseId = Integer.parseInt(courseIdParam);

                // Use the CourseDAO to delete the course
                CourseDAO courseDAO = new CourseDAO();
                boolean deleted = courseDAO.deleteCourse(courseId);

                if (deleted) {
                    // Redirect to a success page or list of courses
                    response.sendRedirect(request.getContextPath() + "/ListCoursesServlet");
                }
            } catch (NumberFormatException e) {
                // Handle the case when the course ID parameter is not a valid number
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        }
    }
}
