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
import dao.StudentDAO;
import dao.StudentRegistrationDAO;
import model.AcademicUnit;
import model.Semester;
import model.Student;
import model.StudentRegistration;

@SuppressWarnings("serial")
@WebServlet("/EditStudentRegistrationServlet")
public class EditStudentRegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentRegistrationId = Integer.parseInt(request.getParameter("id"));
        StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
        StudentRegistration studentRegistration = studentRegistrationDAO.getStudentRegistrationById(studentRegistrationId);

        if (studentRegistration != null) {
            // Assuming you have retrieved the list of students, academic units, and semesters from the database
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = studentDAO.getAllStudents();

            AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
            List<AcademicUnit> academicUnits = academicUnitDAO.getAllAcademicUnits();

            SemesterDAO semesterDAO = new SemesterDAO();
            List<Semester> semesters = semesterDAO.getAllSemesters();

            request.setAttribute("studentRegistration", studentRegistration);
            request.setAttribute("students", students);
            request.setAttribute("academicUnits", academicUnits);
            request.setAttribute("semesters", semesters);

            request.getRequestDispatcher("/editStudentRegistration.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentRegistrationId = Integer.parseInt(request.getParameter("id"));
        String studentIdString = request.getParameter("studentId");
        String academicUnitIdString = request.getParameter("academicUnitId");
        String semesterIdString = request.getParameter("semesterId");
        String registrationDate = request.getParameter("registrationDate");
        String status = request.getParameter("status");

        int studentId = Integer.parseInt(studentIdString);
        int academicUnitId = Integer.parseInt(academicUnitIdString);
        int semesterId = Integer.parseInt(semesterIdString);

        StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
        StudentRegistration studentRegistration = studentRegistrationDAO.getStudentRegistrationById(studentRegistrationId);

        if (studentRegistration != null) {
            // Retrieve the student, academic unit, and semester from the database
            StudentDAO studentDAO = new StudentDAO();
            Student student = studentDAO.getStudentById(studentId);

            AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
            AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicUnitId);

            SemesterDAO semesterDAO = new SemesterDAO();
            Semester semester = semesterDAO.getSemesterById(semesterId);

            // Update the student registration object
            studentRegistration.setStudent(student);
            studentRegistration.setAcademicUnit(academicUnit);
            studentRegistration.setSemester(semester);
            studentRegistration.setRegistrationDate(registrationDate);
            studentRegistration.setStatus(status);

            studentRegistrationDAO.saveOrUpdate(studentRegistration);
            response.sendRedirect(request.getContextPath() + "/ListStudentRegistrationsServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
