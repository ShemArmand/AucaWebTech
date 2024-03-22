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

@WebServlet("/getCoursesByDepartmentAndSemester")
public class GetCoursesByDepartmentAndSemesterServlet extends HttpServlet {
    private SemesterDAO semesterService;
    private AcademicUnitDAO academicService;
    private StudentRegistrationDAO studentRegistrationService;

    public void init() {
        semesterService = new SemesterDAO(); // Initialize your Semester service
        academicService = new AcademicUnitDAO(); // Initialize your AcademicUnit service
        studentRegistrationService = new StudentRegistrationDAO(); // Initialize your StudentRegistration service
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String semesterParam = request.getParameter("semester");
        String departmentParam = request.getParameter("department");

        List<Semester> allSemesters = semesterService.getAllSemesters();
        List<AcademicUnit> allDepartments = academicService.getAllAcademicUnits();
        List<AcademicUnit> courses;

        if (semesterParam != null && !semesterParam.isEmpty() && departmentParam != null && !departmentParam.isEmpty()) {
            try {
                Integer semesterId = Integer.parseInt(semesterParam);
                Integer departmentId = Integer.parseInt(departmentParam);
                courses = fetchCoursesByDepartmentAndSemester(departmentId, semesterId);

                // Update the coursesByDepartmentAndSemester table with the selected department and semester
                academicService.updateCoursesByDepartmentAndSemester(departmentId, semesterId, courses);
            } catch (NumberFormatException e) {
                // Handle invalid input (e.g., non-integer values)
                courses = null; // or you can set it to an empty list
            }
        } else {
            courses = studentRegistrationService.getAllCourses(); // Fetch all courses
        }

        request.setAttribute("semesters", allSemesters);
        request.setAttribute("departments", allDepartments);
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("coursesByDepartmentAndSemester2.jsp").forward(request, response);
    }

    private List<AcademicUnit> fetchCoursesByDepartmentAndSemester(int departmentId, int semesterId) {
        return studentRegistrationService.getCoursesByDepartmentAndSemester(departmentId, semesterId);
    }
}