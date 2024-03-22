package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AcademicUnit;
import model.Course;
import model.Semester;
import model.Student;
import model.StudentRegistration;
import dao.AcademicUnitDAO;
import dao.CourseDAO;
import dao.SemesterDAO;
import dao.StudentDAO;
import dao.StudentRegistrationDAO;
import service.StudentService;
import ServiceImp.StudentServiceImpl;


@WebServlet("/student")
public class StudentController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private StudentDAO studentService;
    private StudentRegistrationDAO studentRegistationService;
    private SemesterDAO semesterService;
    private AcademicUnitDAO academicService;
    private CourseDAO courseService;
    

    public void init() {
        // Initialize StudentService here or inject it using a dependency injection framework
        studentService = new StudentDAO();
        studentRegistationService = new StudentRegistrationDAO();
        semesterService = new SemesterDAO();
        academicService = new AcademicUnitDAO();
        courseService = new CourseDAO();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

         if ("listStudentsBySemester".equals(action)) {
            String semesterParam = request.getParameter("semester");
            List<Semester> allSemesters = semesterService.getAllSemesters();
            List<StudentRegistration> students;
            
            if (semesterParam != null && !semesterParam.isEmpty()) {
                Integer semester = Integer.parseInt(semesterParam);
                students = studentRegistationService.getStudentRegistrationsBySemester(semester);
            } else {
                students = studentRegistationService.getAllStudentRegistrations();
            }
            
            request.setAttribute("students", students);
            request.setAttribute("semesters", allSemesters);
            request.getRequestDispatcher("studentsBySemester.jsp").forward(request, response);
        } else if ("listStudentsByDepartmentAndSemester".equals(action)) {
        	 String semesterParam = request.getParameter("semester");
        	 String departmentParam = request.getParameter("departmentId");
        	 
//        	Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
//        	Integer semesterId = Integer.parseInt(request.getParameter("semester"));
        	
        	List<Semester> allSemesters = semesterService.getAllSemesters();
        	List<AcademicUnit> allAcademicUnits = academicService.getAllAcademicUnits();
        	List<StudentRegistration> students;
        	
        	if (semesterParam != null && !semesterParam.isEmpty() || departmentParam != null && !departmentParam.isEmpty()) {
        		 Integer semesterId = Integer.parseInt(semesterParam);
        		 Integer departmentId = Integer.parseInt(departmentParam);
                students = studentRegistationService.getStudentsByDepartmentAndSemester(departmentId, semesterId);
            } else {
                students = studentRegistationService.getAllStudentRegistrations();
            }
        	

        	
        	
        	request.setAttribute("semesters", allSemesters);
        	request.setAttribute("departments", allAcademicUnits);
            request.setAttribute("students", students);
            request.getRequestDispatcher("studentsByDepartmentAndSemester.jsp").forward(request, response);
        }else if ("listStudentsByDepartmentAndSemester".equals(action)) {
       	 String semesterParam = request.getParameter("semester");
       	 String departmentParam = request.getParameter("departmentId");
       	 
//       	Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
//       	Integer semesterId = Integer.parseInt(request.getParameter("semester"));
       	
       	List<Semester> allSemesters = semesterService.getAllSemesters();
       	List<AcademicUnit> allAcademicUnits = academicService.getAllAcademicUnits();
       	List<StudentRegistration> students;
       	
       	if (semesterParam != null && !semesterParam.isEmpty() || departmentParam != null && !departmentParam.isEmpty()) {
       		 Integer semesterId = Integer.parseInt(semesterParam);
       		 Integer departmentId = Integer.parseInt(departmentParam);
               students = studentRegistationService.getStudentsByDepartmentAndSemester(departmentId, semesterId);
           } else {
               students = studentRegistationService.getAllStudentRegistrations();
           }
       	

       	
       	
       	request.setAttribute("semesters", allSemesters);
       	request.setAttribute("departments", allAcademicUnits);
           request.setAttribute("students", students);
           request.getRequestDispatcher("studentsByDepartmentAndSemester.jsp").forward(request, response);
       } else if ("listCourseByDepartmentAndSemester".equals(action)) {

       	 String semesterParam = request.getParameter("semester");
       	 String departmentParam = request.getParameter("department");
       	 
       	List<Semester> allSemesters = semesterService.getAllSemesters();
    	List<AcademicUnit> allDepartments = academicService.getAllAcademicUnits();
    	
    	List<Course> courses;
    	
//    	if (semesterParam != null && !semesterParam.isEmpty() || courseParam != null && !courseParam.isEmpty()) {
//   		 Integer semesterId = Integer.parseInt(semesterParam);
//   		 Integer courseId = Integer.parseInt(courseParam);
//           students = studentRegistationService.getStudentsByCourseAndSemester(courseId, semesterId);
//       } else {
//           students = studentRegistationService.getAllStudentRegistrations();
//       }
       	 

    	request.setAttribute("semesters", allSemesters);
    	request.setAttribute("departments", allDepartments);
//    	  request.setAttribute("students", students);
            request.getRequestDispatcher("coursesByDepartmentAndSemester.jsp").forward(request, response);
        } else if("allStudents".equals(action))if ("allStudents".equals(action)) {
            List<Student> students = studentService.getAllStudents();
            request.setAttribute("students", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("allStudents.jsp");
            dispatcher.forward(request, response);
        }else if ("register".equals(action)) {
            // Display the login page
            RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        } else if ("signup".equals(action)) {
            // Display the sign up page
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
            dispatcher.forward(request, response);
        }else {
            // Handle the default case here (e.g., redirect to a home page)
            response.sendRedirect("index.jsp");
        } 
        	
//        	if ("listCoursesByDepartmentAndSemester".equals(action)) {
//            Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
//            String semesterId = request.getParameter("semester");
//            List<Course> courses = courseService.getCoursesByDepartmentAndSemester(departmentId, semesterId);
//            request.setAttribute("courses", courses);
//            request.getRequestDispatcher("coursesByDepartmentAndSemester.jsp").forward(request, response);
//        } else if ("listCoursesByStudent".equals(action)) {
//            Long studentId = Long.parseLong(request.getParameter("studentId"));
//            List<Course> courses = courseService.getCoursesByStudent(studentId);
//            request.setAttribute("courses", courses);
//            request.getRequestDispatcher("coursesByStudent.jsp").forward(request, response);
//        } 
    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        if ("CreateStudent".equals(action)) {
//            // Retrieve student information from the form
//            String regNo = request.getParameter("regNo");
//            String firstName = request.getParameter("firstName");
//            String dateOfBirth = request.getParameter("dateOfBirth");
//
//            // Create a new Student object and set its properties
//            Student newStudent = new Student();
//            newStudent.setRegNo(regNo);
//            newStudent.setFirstName(firstName);
//            newStudent.setDateOfBirth(dateOfBirth);
//
//            // Perform database operation to save the new student
//            studentService.saveOrUpdate(newStudent);
//
//            // Forward to a confirmation page or another appropriate page
//            RequestDispatcher dispatcher = request.getRequestDispatcher("studentCreatedConfirmation.jsp");
//            dispatcher.forward(request, response);
//        }
//    }

}


