package control;

import java.util.List;

import model.Course;
import service.CourseService;

public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<Course> getCoursesByDepartmentAndSemester(Integer departmentId, String semesterId) {
        return courseService.getCoursesByDepartmentAndSemester(departmentId, semesterId);
    }
    public List<Course> getCoursesByStudent(Integer studentId) {
        return courseService.getCoursesByStudent(studentId);
    }
}
