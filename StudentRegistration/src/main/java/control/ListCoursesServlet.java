package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.TeacherDAO;
import model.Course;
import model.Teacher;

@WebServlet("/ListCoursesServlet")
public class ListCoursesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            // Handle viewing a single course for editing
            int courseId = Integer.parseInt(request.getParameter("id"));
            
            CourseDAO courseDAO = new CourseDAO();
            Course course = courseDAO.getCourseById(courseId);
            
            
            

            if (course != null) {
                request.setAttribute("course", course);
                request.getRequestDispatcher("/editCourse.jsp").forward(request, response);
            } else {
                // Handle the case when the course is not found (e.g., show an error page)
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // List all courses
            CourseDAO courseDAO = new CourseDAO();
            List<Course> courses = courseDAO.getAllCourses();

            request.setAttribute("courses", courses);
            request.getRequestDispatcher("/allCourses.jsp").forward(request, response);
            
            
        }
    }
}
