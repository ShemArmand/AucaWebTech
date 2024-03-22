package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SemesterDAO;
import model.Semester;

@WebServlet("/ListSemestersServlet")
public class ListSemestersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            // Handle viewing a single semester for editing
            int semesterId = Integer.parseInt(request.getParameter("id"));
            SemesterDAO semesterDAO = new SemesterDAO();
            Semester semester = semesterDAO.getSemesterById(semesterId);

            if (semester != null) {
                request.setAttribute("semester", semester);
                request.getRequestDispatcher("/editSemester.jsp").forward(request, response);
            } else {
                // Handle the case when the semester is not found (e.g., show an error page)
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // List all semesters
            SemesterDAO semesterDAO = new SemesterDAO();
            List<Semester> semesters = semesterDAO.getAllSemesters();

            request.setAttribute("semesters", semesters);
            request.getRequestDispatcher("/allSemesters.jsp").forward(request, response);
        }
    }
}

