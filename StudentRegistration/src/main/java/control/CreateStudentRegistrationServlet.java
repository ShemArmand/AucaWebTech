package control;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcademicUnitDAO;
import dao.StudentRegistrationDAO;
import dao.StudentDAO;
import dao.SemesterDAO;
import model.AcademicUnit;
import model.Student;
import model.StudentRegistration;
import model.Semester;

@SuppressWarnings("serial")
@WebServlet("/CreateStudentRegistrationServlet")
public class CreateStudentRegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the necessary data from your data source
        
        // Retrieve the list of students
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getAllStudents();
        
        // Retrieve the list of academic units
        AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
        List<AcademicUnit> academicUnits = academicUnitDAO.getAllAcademicUnits();
        
        // Retrieve the list of semesters
        SemesterDAO semesterDAO = new SemesterDAO();
        List<Semester> semesters = semesterDAO.getAllSemesters();

        // Pass the data to the JSP
        request.setAttribute("students", students);
        request.setAttribute("academicUnits", academicUnits);
        request.setAttribute("semesters", semesters);

        // Forward to the JSP
        request.getRequestDispatcher("/createStudentRegistrationForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request to create a student registration
        
        // Retrieve and process the form data to create a new student registration record
        String studentIdString = request.getParameter("studentId");
        String academicUnitIdString = request.getParameter("academicUnitId");
        String semesterIdString = request.getParameter("semesterId");
        String registrationDate = request.getParameter("registrationDate"); // Assuming registration date is provided in the form
        String status = request.getParameter("status"); // Retrieve the "status" field

        // Validate the form data
        if (studentIdString == null || academicUnitIdString == null || semesterIdString == null || status == null) {
            // Handle invalid form data error
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid form data");
            return;
        }
        
        try {
            // Parse the integer values
            int studentId = Integer.parseInt(studentIdString);
            int academicUnitId = Integer.parseInt(academicUnitIdString);
            int semesterId = Integer.parseInt(semesterIdString);
            
            // Retrieve the student, academic unit, and semester from the database
            StudentDAO studentDAO = new StudentDAO();
            Student student = studentDAO.getStudentById(studentId);
            
            AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
            AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicUnitId);
            
            SemesterDAO semesterDAO = new SemesterDAO();
            Semester semester = semesterDAO.getSemesterById(semesterId);
            
            // Create a new student registration object
            StudentRegistration studentRegistration = new StudentRegistration();
            studentRegistration.setStudent(student);
            studentRegistration.setAcademicUnit(academicUnit);
            studentRegistration.setSemester(semester);
            studentRegistration.setRegistrationDate(registrationDate);
            studentRegistration.setStatus(status); // Set the "status" field

            
            // Save the student registration to the database
            StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
            studentRegistrationDAO.saveOrUpdate(studentRegistration);
            
            // Redirect to a success page or appropriate location
            response.sendRedirect(request.getContextPath() + "/ListStudentRegistrationsServlet");
        } catch (NumberFormatException e) {
            // Handle invalid integer values error
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid integer values");
        } catch (DateTimeParseException e) {
            // Handle invalid registration date error
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid registration date");
        }
    }
}
