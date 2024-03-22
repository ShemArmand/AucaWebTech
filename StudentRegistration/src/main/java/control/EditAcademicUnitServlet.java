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
@WebServlet("/EditAcademicUnitServlet")
public class EditAcademicUnitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int academicUnitId = Integer.parseInt(request.getParameter("id"));
        AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
        AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicUnitId);

        if (academicUnit != null) {
            // Assuming you have retrieved the list of academic units and parent units from the database
            List<AcademicUnit> academicUnits = academicUnitDAO.getAllAcademicUnits();
            List<AcademicUnit> parentUnits = academicUnitDAO.getAllParentUnits(); // Adjust this query according to your data structure

            request.setAttribute("academicUnit", academicUnit);
            request.setAttribute("academicUnits", academicUnits);
            request.setAttribute("parentUnits", parentUnits);
            
            request.getRequestDispatcher("/editAcademicUnit.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	    int academicUnitId = Integer.parseInt(request.getParameter("id"));
    	    String code = request.getParameter("code");
    	    String name = request.getParameter("name");
    	    String academicType = request.getParameter("academicType");
    	    String parentUnitIdString = request.getParameter("parentUnitId");
    	    
    	    int parentUnitId = 0; // Default value

    	    

    	    if (parentUnitIdString != null && !parentUnitIdString.isEmpty()) {
    	        parentUnitId = Integer.parseInt(parentUnitIdString);
    	    }

    	    AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
    	    AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicUnitId);

    	    if (academicUnit != null) {
    	        academicUnit.setCode(code);
    	        academicUnit.setName(name);
    	        academicUnit.setAcademicType(AcademicUnit.AcademicEnum.valueOf(academicType));

    	        // Only set the parent unit if a valid parentUnitId is provided
    	        if (parentUnitId != 0) {
    	            AcademicUnit parentUnit = academicUnitDAO.getAcademicUnitById(parentUnitId);
    	            academicUnit.setParentUnit(parentUnit);
    	        }

    	        academicUnitDAO.saveOrUpdate(academicUnit);
    	        response.sendRedirect(request.getContextPath() + "/ListAcademicUnitsServlet");
    	        System.out.println("Parent Unit ID: " + parentUnitId);

    	    } else {
    	        response.sendRedirect(request.getContextPath() + "/error.jsp");
    	    }
    	}
}
