package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Student;
import util.HibernateUtil;

@WebServlet("/CreateStudentServlet")
public class CreateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String regNo = request.getParameter("regNo");
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setRegNo(regNo);
        student.setName(name);
        student.setDateOfBirth(dateOfBirth);

        try {
            session.save(student);
            transaction.commit();
            response.sendRedirect(request.getContextPath() + "/ListStudentsServlet");
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
        // Display the student creation form (GET request handling)
        request.getRequestDispatcher("/createStudentForm.jsp").forward(request, response);
    }
}
