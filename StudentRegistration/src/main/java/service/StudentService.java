package service;

import java.util.List;

import model.Student;

public interface StudentService {
    List<Student> getStudentsBySemester(String semesterId);
    List<Student> getStudentsByDepartmentAndSemester(Integer departmentId, String semesterId);
    List<Student> getStudentsByCourseAndSemester(String courseId, String semesterId);
}
