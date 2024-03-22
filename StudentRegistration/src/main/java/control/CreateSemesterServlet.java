package control;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SemesterDAO;
import model.Semester;

@WebServlet("/CreateSemesterServlet")
public class CreateSemesterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request, if needed
        // For example, you can show an empty form for creating a semester
        // Forward to a JSP that displays the form
        request.getRequestDispatcher("/createSemesterForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request to create a semester
        // Retrieve and process the form data to create a new semester record
        String name = request.getParameter("name");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

        // Create a Semester object and set its properties
        Semester semester = new Semester();
        semester.setName(name);
        semester.setStartDate(startDate);
        semester.setEndDate(endDate);

        // Save the semester to the database using your SemesterDAO
        SemesterDAO semesterDAO = new SemesterDAO();
        semesterDAO.saveOrUpdate(semester);

        // Redirect to a success page or list of semesters
        response.sendRedirect(request.getContextPath() + "/ListSemestersServlet");
    }
}
