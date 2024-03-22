package ServiceImp;

import java.util.List;

import dao.StudentDAO;
import model.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;
    

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getStudentsBySemester(String semesterId) {
        return studentDAO.getStudentsBySemester(semesterId);
    }

	@Override
	public List<Student> getStudentsByDepartmentAndSemester(Integer departmentId, String semesterId) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentsByDepartmentAndSemester(departmentId, semesterId);
	}

	@Override
	public List<Student> getStudentsByCourseAndSemester(String courseId, String semesterId) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentsByCourseAndSemester(courseId, semesterId);
	}
}
