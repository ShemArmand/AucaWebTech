package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.RegistrarUser;
import util.HibernateUtil;

@WebServlet("/CreateRegistrarUserServlet")
public class CreateRegistrarUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String registrarNames = request.getParameter("registrarNames");
        String registrarPhone = request.getParameter("registrarPhone");
        String registrarUserName = request.getParameter("registrarUserName");
        String registrarPassword = request.getParameter("registrarPassword");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        RegistrarUser registrarUser = new RegistrarUser();
        registrarUser.setRegistrarNames(registrarNames); // Set the correct field name
        registrarUser.setRegistrarPhone(registrarPhone);
        registrarUser.setRegistrarUserName(registrarUserName);
        registrarUser.setRegistrarPassword(registrarPassword);

        try {
            session.save(registrarUser);
            transaction.commit();
            response.sendRedirect(request.getContextPath() + "/LoginRegistrarUserServlet");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } finally {
            session.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Display the registrar user creation form (GET request handling)
        request.getRequestDispatcher("/createRegistrarUserForm.jsp").forward(request, response);
    }
}
