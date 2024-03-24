package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.RegistrarUser;
import util.HibernateUtil;

@WebServlet("/LoginRegistrarUserServlet")
public class LoginRegistrarUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Session session = HibernateUtil.getSessionFactory().openSession();

        // Use HQL (Hibernate Query Language) to check if the user exists
        String hql = "FROM RegistrarUser R WHERE R.registrarUserName = :username AND R.registrarPassword = :password";
        Query<RegistrarUser> query = session.createQuery(hql, RegistrarUser.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        RegistrarUser user = query.uniqueResult();

        if (user != null) {
            // User exists, set session attribute to mark as logged in
            HttpSession httpSession = request.getSession();
            httpSession.setMaxInactiveInterval(1 * 60); // Set timeout in seconds
            httpSession.setAttribute("loggedInUser", user);
            Cookie loginCookie = new Cookie("LogUser",user.getRegistrarUserName());

            // Redirect to a success page
            response.sendRedirect(request.getContextPath() + "/index.html");
            response.addCookie(loginCookie);
        } else {
            // User does not exist or login failed
            response.sendRedirect(request.getContextPath() + "/loginFailed.jsp");
        }

        session.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Display the login form (GET request handling)
        request.getRequestDispatcher("/loginn.jsp").forward(request, response);
    }
}
