package ServiceImp;

import java.util.List;

import dao.CourseDAO;
import model.Course;
import service.CourseService;

public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO;

    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> getCoursesByDepartmentAndSemester(Integer departmentId, String semesterId) {
        return courseDAO.getCoursesByDepartmentAndSemester(departmentId, semesterId);
    }

	@Override
	public List<Course> getCoursesByStudent(Integer studentId) {
		 TODO Auto-generated method stub
		return courseDAO.getCoursesByStudent(studentId);
	}
}
