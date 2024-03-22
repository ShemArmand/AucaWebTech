package control;

import dao.SemesterDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteSemesterServlet")
public class DeleteSemesterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String semesterIdParam = request.getParameter("id");

        if (semesterIdParam != null) {
            try {
                int semesterId = Integer.parseInt(semesterIdParam);

                SemesterDAO semesterDAO = new SemesterDAO();
                boolean deleted = semesterDAO.deleteSemester(semesterId);

                if (deleted) {
                    response.sendRedirect(request.getContextPath() + "/ListSemestersServlet");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        }
    }
}
