<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.StudentRegistration" %>
<%@ page import="model.Semester" %>
<%@ page import="model.AcademicUnit" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students by Department and Semester</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom styles */
        body {
            padding: 20px;
        }
        h1 {
            margin-bottom: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        table {
            width: 100%;
        }
        table th,
        table td {
            padding: 10px;
            text-align: left;
        }
        table th {
            background-color: #f8f9fa;
        }
        table tbody tr:nth-child(even) {
            background-color: #f8f9fa;
        }
        .no-records {
            font-style: italic;
            text-align: center;
            color: #888;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Students by Department and Semester</h1>

        <form action="student" method="get">
            <input type="hidden" name="action" value="listStudentsByDepartmentAndSemester">
            <div class="form-group">
                <label for="department">Select Department:</label>
                <select class="form-control" id="departmentId" name="departmentId">
                    <option value="" selected>All Students</option>
                    <% 
                    List<AcademicUnit> academics = (List<AcademicUnit>) request.getAttribute("departments");
                    if (academics != null) {
                        for (AcademicUnit academic : academics) {
                    %>
                    <%-- Check if the current department is selected --%>
                    <% 
                    String selectedAcademicUnit = request.getParameter("departmentId");
                    boolean isSelected = selectedAcademicUnit != null && selectedAcademicUnit.equals(academic.getId());
                    %>
                    <option value="<%= academic.getId() %>" <%= isSelected ? "selected" : "" %>>
                        <%= academic.getName() %>
                    </option>
                    <% 
                        }
                    }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label for="semester">Select Semester:</label>
                <select class="form-control" id="semester" name="semester" required>
                    <option value="" selected>All Students</option>
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
            </div>
            <input type="submit" class="btn btn-primary" value="Show Students">
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
                    <td colspan="3" class="no-records">No records found!</td>
                </tr>
                <% 
                }
                %>
            </tbody>
        </table>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>