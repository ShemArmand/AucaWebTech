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
    <title>Students by Course and Semester</title>
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
        <h1>Students by Course and Semester</h1>

        <form action="/getStudentsByCourseAndSemester" method="get">
            <div class="form-group">
                <label for="course">Select Course:</label>
                <select class="form-control" id="course" name="course">
                    <option value="" selected>All Courses</option>
                    <c:forEach items="${courses}" var="course">
                        <option value="${course.id}">
                            ${course.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="semester">Select Semester:</label>
                <select class="form-control" id="semester" name="semester">
                    <option value="" selected>All Semesters</option>
                    <c:forEach items="${semesters}" var="semester">
                        <option value="${semester.id}">
                            ${semester.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" class="btn btn-primary" value="Show Students">
        </form>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Student Name</th>
                    <th>Semester</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.student.name}</td>
                        <td>${student.semester.name}</td>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${empty students}">
                        <tr>
                            <td colspan="3" class="no-records">No records found!</td>
                        </tr>
                    </c:when>
                </c:choose>
            </tbody>
        </table>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>