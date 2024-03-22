package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcademicUnitDAO;
import model.AcademicUnit;

@WebServlet("/ListAcademicUnitsServlet")
public class ListAcademicUnitsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            // Handle viewing a single academic unit for editing
            int academicUnitId = Integer.parseInt(request.getParameter("id"));
            AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
            AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicUnitId);

            if (academicUnit != null) {
                request.setAttribute("academicUnit", academicUnit);
                request.getRequestDispatcher("/editAcademicUnit.jsp").forward(request, response);
            } else {
                // Handle the case when the academic unit is not found (e.g., show an error page)
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // List all academic units
            AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
            List<AcademicUnit> academicUnits = academicUnitDAO.getAllAcademicUnits();

            request.setAttribute("academicUnits", academicUnits);
            request.getRequestDispatcher("/allAcademicUnits.jsp").forward(request, response);
        }
    }
}
