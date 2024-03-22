package control;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcademicUnitDAO;
import dao.SemesterDAO;
import dao.StudentRegistrationDAO;
import model.AcademicUnit;
import model.Course; // Import Course
import model.Semester;
import model.StudentRegistration;

@WebServlet("/getCoursesByStudent")
public class GetCoursesByStudentServlet extends HttpServlet {
    private SemesterDAO semesterService;
    private AcademicUnitDAO academicService;
    private StudentRegistrationDAO studentRegistrationService;

    public void init() {
        semesterService = new SemesterDAO();
        academicService = new AcademicUnitDAO();
        studentRegistrationService = new StudentRegistrationDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentParam = request.getParameter("student");

        List<Semester> allSemesters = semesterService.getAllSemesters();
        List<AcademicUnit> allStudents = fetchAllStudents();
        List<Course> courses = Collections.emptyList(); // Initialize courses as an empty list

        if (studentParam != null && !studentParam.isEmpty()) {
            try {
                Integer studentId = Integer.parseInt(studentParam);
                courses = studentRegistrationService.getStudentCourses(studentId);
            } catch (NumberFormatException e) {
                // Handle invalid input (e.g., non-integer values)
                courses = Collections.emptyList(); // Set courses to an empty list
            }
        }

        request.setAttribute("semesters", allSemesters);
        request.setAttribute("students", allStudents);
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("coursesByStudent.jsp").forward(request, response);
    }


    private List<AcademicUnit> fetchAllStudents() {
        // Replace this with your actual data retrieval logic
        return academicService.getAllAcademicUnits(); // Assuming you have a list of students in AcademicUnit
    }
}
