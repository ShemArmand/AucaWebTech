package service;

import java.util.List;

import model.Course;

public interface CourseService {
    List<Course> getCoursesByDepartmentAndSemester(Integer departmentId, String semesterId);
    List<Course> getCoursesByStudent(Integer studentId);
}