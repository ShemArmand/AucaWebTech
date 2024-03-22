package control;

import dao.StudentRegistrationDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStudentRegistrationServlet")
public class DeleteStudentRegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student registration ID to be deleted from the request parameter
        String studentRegistrationIdParam = request.getParameter("id");

        if (studentRegistrationIdParam != null) {
            try {
                int studentRegistrationId = Integer.parseInt(studentRegistrationIdParam);

                // Use the StudentRegistrationDAO to delete the student registration
                StudentRegistrationDAO studentRegistrationDAO = new StudentRegistrationDAO();
                boolean deleted = studentRegistrationDAO.deleteStudentRegistration(studentRegistrationId);

                if (deleted) {
                    // Redirect to a success page or list of student registrations
                    response.sendRedirect(request.getContextPath() + "/ListStudentRegistrationsServlet");
                } else {
                    // Handle the case when the student registration was not successfully deleted
                    response.sendRedirect(request.getContextPath() + "/error.jsp");
                }
            } catch (NumberFormatException e) {
                // Handle the case when the student registration ID parameter is not a valid number
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // Handle the case when the student registration ID parameter is not provided
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
