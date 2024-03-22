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

@SuppressWarnings("serial")
@WebServlet("/CreateAcademicUnitServlet")
public class CreateAcademicUnitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the parent units from your data source
        AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
        List<AcademicUnit> parentUnits = academicUnitDAO.getAllParentUnits();

        // Pass the parentUnits to the JSP
        request.setAttribute("parentUnits", parentUnits);

        // Forward to the JSP
        request.getRequestDispatcher("/createAcademicUnitForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request to create an academic unit
        // Retrieve and process the form data to create a new academic unit record
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String parentUnitId = request.getParameter("parentUnitId");
        String academicType = request.getParameter("academicType");

        // Create an AcademicUnit object and set its properties
        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setCode(code);
        academicUnit.setName(name);

        if (parentUnitId != null && !parentUnitId.isEmpty()) {
            AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
            AcademicUnit parentUnit = academicUnitDAO.getAcademicUnitById(Integer.parseInt(parentUnitId));
            academicUnit.setParentUnit(parentUnit);
        }

        academicUnit.setAcademicType(AcademicUnit.AcademicEnum.valueOf(academicType)); // Assuming academicType is an enum

        // Save the academic unit to the database using your AcademicUnitDAO
        AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
        academicUnitDAO.saveOrUpdate(academicUnit);

        // Redirect to a success page or list of academic units
        response.sendRedirect(request.getContextPath() + "/ListAcademicUnitsServlet");
    }
}
