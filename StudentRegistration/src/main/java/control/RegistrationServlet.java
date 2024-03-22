package control;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import model.*;
import dao.*;


public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String registrationDate = request.getParameter("registrationDate");
        String status = request.getParameter("status");
        int academicUnitId = Integer.parseInt(request.getParameter("academicUnit"));
        int semesterId = Integer.parseInt(request.getParameter("semester"));
//        StudentRegistration.StatusEnum status = StudentRegistration.StatusEnum.valueOf(request.getParameter("status"));

        // Create StudentRegistration object
        Student student = new Student(); // You need to create the Student object or retrieve it from the database
        AcademicUnit academicUnit = new AcademicUnit(); // You need to create the AcademicUnit object or retrieve it from the database
        Semester semester = new Semester(); // You need to create the Semester object or retrieve it from the database
        
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.setStudent(student);
        studentRegistration.setRegistrationDate(registrationDate);
        studentRegistration.setAcademicUnit(academicUnit);
        studentRegistration.setSemester(semester);
        studentRegistration.setStatus(status);

        // Save the StudentRegistration object
        StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
        studentRegistrationDAO.saveOrUpdate(studentRegistration);

        // Redirect to a success page or display a success message
        response.sendRedirect("allStudents.jsp");
    }
}