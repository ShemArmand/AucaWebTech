package control;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;
import model.Teacher;

@WebServlet("/ListTeachersServlet")
public class ListTeachersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            // Handle viewing a single teacher for editing
            int teacherCode = Integer.parseInt(request.getParameter("code"));
            TeacherDAO teacherDAO = new TeacherDAO();
            Teacher teacher = teacherDAO.getTeacherByCode(teacherCode);

            if (teacher != null) {
                request.setAttribute("teacher", teacher);
                request.getRequestDispatcher("/editTeacher.jsp").forward(request, response);
            } else {
                // Handle the case when the teacher is not found (e.g., show an error page)
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // List all teachers
            TeacherDAO teacherDAO = new TeacherDAO();
            List<Teacher> teachers = teacherDAO.getAllTeachers();

            request.setAttribute("teachers", teachers);
            request.getRequestDispatcher("/allTeachers.jsp").forward(request, response);
        }
    }
}
