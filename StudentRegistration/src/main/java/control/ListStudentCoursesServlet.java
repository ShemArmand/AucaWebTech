package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentCourseDAO;
import model.StudentCourse;

@WebServlet("/ListStudentCoursesServlet")
public class ListStudentCoursesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve a list of student courses from the database using your DAO
        StudentCourseDAO studentCourseDAO = new StudentCourseDAO();
        List<StudentCourse> studentCourses = studentCourseDAO.getAllStudentCourses();

        // Set the list of student courses as a request attribute
        request.setAttribute("studentCourses", studentCourses);

        // Forward the request to a JSP for rendering
        request.getRequestDispatcher("/allStudentCourses.jsp").forward(request, response);
    }
}
