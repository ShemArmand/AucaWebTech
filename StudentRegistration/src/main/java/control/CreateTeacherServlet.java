package control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;
import model.Teacher;
import model.Teacher.QualificationEnum;


@WebServlet("/CreateTeacherServlet")
public class CreateTeacherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request, if needed
        // For example, you can show an empty form for creating a teacher
        // Forward to a JSP that displays the form
        request.getRequestDispatcher("/createTeacherForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST request to create a teacher
        // Retrieve and process the form data to create a new teacher record
        String names = request.getParameter("names");
        String teach = request.getParameter("teach");
        String assistantTutor = request.getParameter("assistantTutor");
        String qualification = request.getParameter("qualification");

        // Create a Teacher object and set its properties
        Teacher teacher = new Teacher();
        teacher.setNames(names);
        teacher.setTeach(teach);
        teacher.setAssistantTutor(assistantTutor);
        teacher.setQualification(Teacher.QualificationEnum.valueOf(qualification)); // Assuming qualification is an enum

        // Save the teacher to the database using your TeacherDAO
        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.saveOrUpdate(teacher);

        // Redirect to a success page or list of teachers
        response.sendRedirect(request.getContextPath() + "/ListTeachersServlet");
    }
}

