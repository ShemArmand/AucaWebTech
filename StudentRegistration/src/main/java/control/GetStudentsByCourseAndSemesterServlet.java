package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcademicUnitDAO;
import dao.SemesterDAO;
import dao.StudentRegistrationDAO;
import model.AcademicUnit;
import model.Semester;
import model.StudentRegistration;

@WebServlet("/getStudentsByCourseAndSemester")
public class GetStudentsByCourseAndSemesterServlet extends HttpServlet {
    private SemesterDAO semesterService;
    private AcademicUnitDAO academicService;
    private StudentRegistrationDAO studentRegistrationService;

    public void init() {
        semesterService = new SemesterDAO(); // Initialize your Semester service
        academicService = new AcademicUnitDAO(); // Initialize your AcademicUnit service
        studentRegistrationService = new StudentRegistrationDAO(); // Initialize your StudentRegistration service
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String semesterParam = request.getParameter("semester");
        String courseParam = request.getParameter("course");

        List<Semester> allSemesters = semesterService.getAllSemesters();
        List<AcademicUnit> allCourses = fetchAllCourses();
        List<StudentRegistration> students = null; // Initialize students with a default value

        if (semesterParam != null && !semesterParam.isEmpty() && courseParam != null && !courseParam.isEmpty()) {
            try {
                Integer semesterId = Integer.parseInt(semesterParam);
                Integer courseId = Integer.parseInt(courseParam);
                students = studentRegistrationService.getStudentsByCourseAndSemester(courseId, semesterId);
            } catch (NumberFormatException e) {
                // Handle invalid input (e.g., non-integer values)
                e.printStackTrace(); // Log the exception for debugging
            }
        } else {
            students = studentRegistrationService.getAllStudentRegistrations();
        }

        request.setAttribute("semesters", allSemesters);
        request.setAttribute("courses", allCourses);
        request.setAttribute("students", students);
        request.getRequestDispatcher("studentsByCourseAndSemester.jsp").forward(request, response);
    }

    private List<AcademicUnit> fetchAllCourses() {
        // Replace this with your actual data retrieval logic
        return academicService.getAllAcademicUnits();
    }
}
