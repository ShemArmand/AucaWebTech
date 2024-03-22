package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDefinitionDAO;
import model.CourseDefinition;

@WebServlet("/ListCourseDefinitionsServlet")
public class ListCourseDefinitionsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // List all course definitions
        CourseDefinitionDAO courseDefinitionDAO = new CourseDefinitionDAO();
        List<CourseDefinition> courseDefinitions = courseDefinitionDAO.getAllCourseDefinitions();

        request.setAttribute("courseDefinitions", courseDefinitions);
        request.getRequestDispatcher("/allCourseDefinitions.jsp").forward(request, response);
    }
}
