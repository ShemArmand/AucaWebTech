package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CourseDefinitionDAO;
import model.CourseDefinition;

@WebServlet("/CreateCourseDefinitionServlet")
public class CreateCourseDefinitionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request to display a form for creating a course definition
        request.getRequestDispatcher("/createCourseDefinitionForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request to create a course definition
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        // Create a CourseDefinition object and set its properties
        CourseDefinition courseDefinition = new CourseDefinition();
        courseDefinition.setCode(code);
        courseDefinition.setName(name);
        courseDefinition.setDescription(description);

        // Save the course definition to the database using your CourseDefinitionDAO
        CourseDefinitionDAO courseDefinitionDAO = new CourseDefinitionDAO();
        courseDefinitionDAO.saveOrUpdate(courseDefinition);

        // Redirect to a success page or list of course definitions
        response.sendRedirect(request.getContextPath() + "/ListCourseDefinitionsServlet");
    }
}
