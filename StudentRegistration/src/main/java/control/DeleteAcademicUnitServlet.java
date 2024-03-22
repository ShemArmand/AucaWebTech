package control;

import dao.AcademicUnitDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteAcademicUnitServlet")
public class DeleteAcademicUnitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the academic unit ID to be deleted from the request parameter
        String academicUnitIdParam = request.getParameter("id");

        if (academicUnitIdParam != null) {
            try {
                int academicUnitId = Integer.parseInt(academicUnitIdParam);

                // Use the AcademicUnitDAO to delete the academic unit
                AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
                boolean deleted = academicUnitDAO.deleteAcademicUnit(academicUnitId);

                if (deleted) {
                    // Redirect to a success page or list of academic units
                    response.sendRedirect(request.getContextPath() + "/ListAcademicUnitsServlet");
                } 
            } catch (NumberFormatException e) {
                // Handle the case when the academic unit ID parameter is not a valid number
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } 
    }
}
