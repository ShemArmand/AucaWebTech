<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.StudentRegistration" %>
<%@ page import="model.Semester" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students by Semester</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Students by Semester</h1>
        
        <form action="student" method="get" class="my-4">
            <input type="hidden" name="action" value="listStudentsBySemester">
            <div class="form-group">
                <label for="semester">Select Semester:</label>
                <select id="semester" name="semester" class="form-control">
                    <option value="" selected>All Students</option>
                    <%
                    List<Semester> semesters = (List<Semester>) request.getAttribute("semesters");
                    if (semesters != null) {
                        for (Semester semester : semesters) {
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
            </div>
            <button type="submit" class="btn btn-primary">Show Students</button>
        </form>
        
        <table class="table">
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
    </div>
    
    <!-- Add Bootstrap JS (Optional) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>