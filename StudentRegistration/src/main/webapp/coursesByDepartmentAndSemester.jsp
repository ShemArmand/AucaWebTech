<
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.StudentRegistration" %>
<%@ page import="model.Semester" %>
<%@ page import="model.Course" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students by Course and Semester</title>
</head>
<body>
    <h1>Students by Course and Semester</h1>
    
   
    <form action="student" method="get">
    <input type="hidden" name="action" value="listCourseByDepartmentAndSemester">
        <label for="course">Select Course:</label>
        <select id="courseId" name="courseId" required>
    	<option value="" selected>All Courses</option>
        <% 
        List<Course> courses = (List<Course>) request.getAttribute("courses");
        if (courses != null) {
            for (Course course : courses) {
        %>
        
        <%-- Check if the current semester is selected --%>
        
        <% 
        String selectedCourse = request.getParameter("courses");
        boolean isSelected = selectedCourse != null && selectedCourse.equals(course.getId());
        %>
        
        <option value="<%= course.getId() %>" <%= isSelected ? "selected" : "" %>>
           <%= course.getCourseDefinition().getName() %>
        </option>
        <% 
            }
        }
        %>
    </select>
        
        <label for="semester">Select Semester:</label>
         <select id="semester" name="semester" required>
    	<option value="" selected>All Semester</option>
        <% 
        List<Semester> semesters = (List<Semester>) request.getAttribute("semesters");
        if (semesters != null) {
            for (Semester semester : semesters) {
        %>
        
        <%-- Check if the current semester is selected --%>
        
        <% 
        String selectedSemester = request.getParameter("semester");
        boolean isSelected = selectedSemester != null && selectedSemester.equals(semester.getId());
        %>
        
        <option value="<%= semester.getId() %>" <%= isSelected ? "selected" : "" %>>
           <%= semester.getName() %>
        </option>
        <% 
            }
        }
        %>
    </select>
        <input type="submit" value="Show Students">
    </form>
    
    
    <table>
    <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Semester</th>
        </tr>
    </thead>
    <tbody>
        <% 
        List<StudentRegistration> students = (List<StudentRegistration>) request.getAttribute("students");
        if (students != null && !students.isEmpty()) {
            for (StudentRegistration student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getStudent().getName() %></td>
            <td><%= student.getSemester().getName() %></td>
        </tr>
        <% 
            }
        } else {
        %>
        <tr>
            <td colspan="3">No records found!</td>
        </tr>
        <% 
        }
        %>
    </tbody>
</table>
</body>
</html>