package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentRegistrationDAO;
import model.StudentRegistration;

@WebServlet("/ListStudentRegistrationsServlet")
public class ListStudentRegistrationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            // Handle viewing a single student registration for editing
            int studentRegistrationId = Integer.parseInt(request.getParameter("id"));
            StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
            StudentRegistration studentRegistration = studentRegistrationDAO.getStudentRegistrationById(studentRegistrationId);

            if (studentRegistration != null) {
                request.setAttribute("studentRegistration", studentRegistration);
                request.getRequestDispatcher("/editStudentRegistration.jsp").forward(request, response);
            } else {
                // Handle the case when the student registration is not found (e.g., show an error page)
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // List all student registrations
            StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
            List<StudentRegistration> studentRegistrations = studentRegistrationDAO.getAllStudentRegistrations();

            request.setAttribute("studentRegistrations", studentRegistrations);
            request.getRequestDispatcher("/allStudentRegistrations.jsp").forward(request, response);
        }
    }
}
