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
import model.AcademicUnit;
import model.Course;
import model.CourseDefinition;
import model.Semester;
import model.Teacher;

@SuppressWarnings("serial")
@WebServlet("/CreateCourseServlet")
public class CreateCourseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the necessary data from your data source

        // Retrieve the list of academic units
        AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
        List<AcademicUnit> academicUnits = academicUnitDAO.getAllAcademicUnits();

        // Retrieve the list of semesters
        SemesterDAO semesterDAO = new SemesterDAO();
        List<Semester> semesters = semesterDAO.getAllSemesters();

        // Retrieve the list of teachers and assistants
        TeacherDAO teacherDAO = new TeacherDAO();
        List<Teacher> teachers = teacherDAO.getAllTeachers();
        
        CourseDefinitionDAO courseDefinitionDAO = new CourseDefinitionDAO();
        List<CourseDefinition> courseDefinitions = courseDefinitionDAO.getAllCourseDefinitions();

        // Pass the data to the JSP
        request.setAttribute("academicUnits", academicUnits);
        request.setAttribute("semesters", semesters);
        request.setAttribute("teachers", teachers);

        request.setAttribute("courseDefinitions", courseDefinitions);


        // Forward to the JSP
        request.getRequestDispatcher("/createCourseForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST request to create a course

        // Retrieve and process the form data to create a new course record
        String courseDefinitionIdString = request.getParameter("courseDefinitionId");
        String academicUnitIdString = request.getParameter("academicUnitId");
        String semesterIdString = request.getParameter("semesterId");
        String teacherIdString = request.getParameter("teacherId");
        String assistantTutorIdString = request.getParameter("assistantTutorId");

        // Validate the form data
        if (courseDefinitionIdString == null || academicUnitIdString == null || semesterIdString == null
                || teacherIdString == null || assistantTutorIdString == null) {
            // Handle invalid form data error
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid form data");
            return;
        }

        try {
            // Parse the integer values
            int courseDefinitionId = Integer.parseInt(courseDefinitionIdString);
            int academicUnitId = Integer.parseInt(academicUnitIdString);
            int semesterId = Integer.parseInt(semesterIdString);
            int teacherId = Integer.parseInt(teacherIdString);
            int assistantTutorId = Integer.parseInt(assistantTutorIdString);

            // Retrieve the course definition, academic unit, semester, teacher, and assistant tutor from the database
            CourseDefinitionDAO courseDefinitionDAO = new CourseDefinitionDAO();
            CourseDefinition courseDefinition = courseDefinitionDAO.getCourseDefinitionById(courseDefinitionId);

            AcademicUnitDAO academicUnitDAO = new AcademicUnitDAO();
            AcademicUnit academicUnit = academicUnitDAO.getAcademicUnitById(academicUnitId);

            SemesterDAO semesterDAO = new SemesterDAO();
            Semester semester = semesterDAO.getSemesterById(semesterId);

            TeacherDAO teacherDAO = new TeacherDAO();
            Teacher teacher = teacherDAO.getTeacherByCode(teacherId);
            Teacher assistantTutor = teacherDAO.getTeacherByCode(assistantTutorId);

            // Create a new course object
            Course course = new Course();
            course.setCourseDefinition(courseDefinition);
            course.setAcademicUnit(academicUnit);
            course.setSemester(semester);
            course.setTeacher(teacher);
            course.setAssistantTutor(assistantTutor);


            // Save the course to the database
            CourseDAO courseDAO = new CourseDAO();
            courseDAO.saveOrUpdate(course);

            // Redirect to a success page or appropriate location
            response.sendRedirect(request.getContextPath() + "/ListCoursesServlet");
            System.out.println("Teacher ID: " + teacherId);
            System.out.println("Assistant Tutor ID: " + assistantTutorId);

        } catch (NumberFormatException e) {
            // Handle the case where one or more parameters are not valid integers
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid integer values");
        }
    }
}