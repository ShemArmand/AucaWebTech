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

@WebServlet("/EditSemesterServlet")
public class EditSemesterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int semesterId = Integer.parseInt(request.getParameter("id"));
        SemesterDAO semesterDAO = new SemesterDAO();
        Semester semester = semesterDAO.getSemesterById(semesterId);

        if (semester != null) {
            request.setAttribute("semester", semester);
            request.getRequestDispatcher("/editSemester.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int semesterId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        // Parse the date strings into LocalDate objects
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        SemesterDAO semesterDAO = new SemesterDAO();
        Semester semester = semesterDAO.getSemesterById(semesterId);

        if (semester != null) {
            semester.setName(name);
            semester.setStartDate(startDate);
            semester.setEndDate(endDate);

            semesterDAO.saveOrUpdate(semester);
            response.sendRedirect(request.getContextPath() + "/ListSemestersServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
