package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CourseDefinitionDAO;
import model.CourseDefinition;

@WebServlet("/EditCourseDefinitionServlet")
public class EditCourseDefinitionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseDefinitionId = Integer.parseInt(request.getParameter("id"));
        CourseDefinitionDAO courseDefinitionDAO = new CourseDefinitionDAO();
        CourseDefinition courseDefinition = courseDefinitionDAO.getCourseDefinitionById(courseDefinitionId);

        if (courseDefinition != null) {
            request.setAttribute("courseDefinition", courseDefinition);
            request.getRequestDispatcher("/editCourseDefinition.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseDefinitionId = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        CourseDefinitionDAO courseDefinitionDAO = new CourseDefinitionDAO();
        CourseDefinition courseDefinition = courseDefinitionDAO.getCourseDefinitionById(courseDefinitionId);

        if (courseDefinition != null) {
            courseDefinition.setCode(code);
            courseDefinition.setName(name);
            courseDefinition.setDescription(description);

            courseDefinitionDAO.saveOrUpdate(courseDefinition);
            response.sendRedirect(request.getContextPath() + "/ListCourseDefinitionsServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
