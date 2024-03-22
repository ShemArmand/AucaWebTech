package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TeacherDAO;
import model.Teacher;

@WebServlet("/EditTeacherServlet")
public class EditTeacherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int teacherCode = Integer.parseInt(request.getParameter("code"));
        TeacherDAO teacherDAO = new TeacherDAO();
        Teacher teacher = teacherDAO.getTeacherByCode(teacherCode);

        if (teacher != null) {
            request.setAttribute("teacher", teacher);
            request.getRequestDispatcher("/editTeacher.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int teacherCode = Integer.parseInt(request.getParameter("code"));
        String names = request.getParameter("names");
        String teach = request.getParameter("teach");
        String assistantTutor = request.getParameter("assistantTutor");
        String qualification = request.getParameter("qualification");

        TeacherDAO teacherDAO = new TeacherDAO();
        Teacher teacher = teacherDAO.getTeacherByCode(teacherCode);

        if (teacher != null) {
            teacher.setNames(names);
            teacher.setTeach(teach);
            teacher.setAssistantTutor(assistantTutor);
            teacher.setQualification(Teacher.QualificationEnum.valueOf(qualification));

            teacherDAO.saveOrUpdate(teacher);
            response.sendRedirect(request.getContextPath() + "/ListTeachersServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
