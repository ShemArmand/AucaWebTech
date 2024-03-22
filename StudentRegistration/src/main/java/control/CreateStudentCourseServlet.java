package control;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentCourseDAO;
import dao.CourseDAO;
import dao.StudentRegistrationDAO;
import model.StudentCourse;
import model.Course;
import model.StudentRegistration;

@WebServlet("/CreateStudentCourseServlet")
public class CreateStudentCourseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request to display a form for creating a student course
        // You may need to retrieve necessary data to populate the form (e.g., list of courses, student registrations, etc.)
        // and pass it to the JSP for rendering the form.

        CourseDAO courseDAO = new CourseDAO();
        List<Course> courses = courseDAO.getAllCourses();

        StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
        List<StudentRegistration> studentRegistrations = studentRegistrationDAO.getAllStudentRegistrations();

        request.setAttribute("courses", courses);
        request.setAttribute("studentRegistrations", studentRegistrations);

        request.getRequestDispatcher("/createStudentCourseForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request to create a student course
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int studentRegistrationId = Integer.parseInt(request.getParameter("studentRegistrationId"));
        int credits = Integer.parseInt(request.getParameter("credits"));
        BigDecimal result = new BigDecimal(request.getParameter("result"));

        // Retrieve the associated Course and StudentRegistration entities
        CourseDAO courseDAO = new CourseDAO();
        Course course = courseDAO.getCourseById(courseId);

        StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
        StudentRegistration studentRegistration = studentRegistrationDAO.getStudentRegistrationById(studentRegistrationId);

        if (course != null && studentRegistration != null) {
            // Create a StudentCourse object and set its properties
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setCourse(course);
            studentCourse.setStudentRegistration(studentRegistration);
            studentCourse.setCredits(credits);
            studentCourse.setResult(result);
            
            // Save the student course to the database using your StudentCourseDAO
            StudentCourseDAO studentCourseDAO = new StudentCourseDAO();
            studentCourseDAO.saveOrUpdate(studentCourse);

            // Redirect to a success page or list of student courses
            response.sendRedirect(request.getContextPath() + "/ListStudentCoursesServlet");
        } else {
            // Handle the case when the Course or StudentRegistration is not found (e.g., show an error page)
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
