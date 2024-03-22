package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcademicUnitDAO;
import dao.CourseDAO;
import dao.CourseDefinitionDAO;
import dao.SemesterDAO;
import dao.TeacherDAO;
import model.Course;
import model.CourseDefinition;
import model.AcademicUnit;
import model.Semester;
import model.Teacher;

@WebServlet("/EditCourseServlet")
public class EditCourseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        CourseDAO courseDAO = new CourseDAO();
        Course course = courseDAO.getCourseById(courseId);
        AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
        SemesterDAO semesterDAO = new SemesterDAO();
        TeacherDAO teacherDAO = new TeacherDAO();

        if (course != null) {
            // Retrieve necessary data for populating dropdown lists
            List<AcademicUnit> academicUnits = academicUnitDAO.getAllAcademicUnits();
            List<Semester> semesters = semesterDAO.getAllSemesters();
            List<Teacher> teachers = teacherDAO.getAllTeachers();

            request.setAttribute("course", course);
            request.setAttribute("academicUnits", academicUnits);
            request.setAttribute("semesters", semesters);
            request.setAttribute("teachers", teachers);

            request.getRequestDispatcher("/editCourse.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        int courseDefinitionId = Integer.parseInt(request.getParameter("courseDefinitionId"));
        int academicUnitId = Integer.parseInt(request.getParameter("academicUnitId"));
        int semesterId = Integer.parseInt(request.getParameter("semesterId"));
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        int assistantTutorId = Integer.parseInt(request.getParameter("assistantTutorId"));

        CourseDAO courseDAO = new CourseDAO();
        Course course = courseDAO.getCourseById(courseId);

        if (course != null) {
            // Retrieve AcademicUnit, Semester, Teacher, and AssistantTutor objects
            AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
            SemesterDAO semesterDAO = new SemesterDAO();
            TeacherDAO teacherDAO = new TeacherDAO();

            // Retrieve the CourseDefinition object based on courseDefinitionId
            CourseDefinitionDAO courseDefinitionDAO = new CourseDefinitionDAO();
            CourseDefinition courseDefinition = courseDefinitionDAO.getCourseDefinitionById(courseDefinitionId);

            AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicUnitId);
            Semester semester = semesterDAO.getSemesterById(semesterId);
            Teacher teacher = teacherDAO.getTeacherByCode(teacherId);
            Teacher assistantTutor = teacherDAO.getTeacherByCode(assistantTutorId);

            // Update the course details with the objects
            course.setCourseDefinition(courseDefinition);
            course.setAcademicUnit(academicUnit);
            course.setSemester(semester);
            course.setTeacher(teacher);
            course.setAssistantTutor(assistantTutor);

            courseDAO.saveOrUpdate(course);
            response.sendRedirect(request.getContextPath() + "/ListCoursesServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

}
