package control;

import dao.CourseDefinitionDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteCourseDefinitionServlet")
public class DeleteCourseDefinitionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the course definition ID to be deleted from the request parameter
        String courseDefinitionIdParam = request.getParameter("id");

        if (courseDefinitionIdParam != null) {
            try {
                int courseDefinitionId = Integer.parseInt(courseDefinitionIdParam);

                // Use the CourseDefinitionDAO to delete the course definition
                CourseDefinitionDAO courseDefinitionDAO = new CourseDefinitionDAO();
                boolean deleted = courseDefinitionDAO.deleteCourseDefinition(courseDefinitionId);

                if (deleted) {
                    // Redirect to a success page or list of course definitions
                    response.sendRedirect(request.getContextPath() + "/ListCourseDefinitionsServlet");
                }
            } catch (NumberFormatException e) {
                // Handle the case when the course definition ID parameter is not a valid number
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        }
    }
}
