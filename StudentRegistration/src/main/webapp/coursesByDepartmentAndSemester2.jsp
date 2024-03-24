<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.AcademicUnit" %>
<%@ page import="model.Semester" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<head>
    <meta charset="UTF-8">
    <title>Courses by Department and Semester</title>
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
        <h1>Courses by Department and Semester</h1>

        <form action="/getCoursesByDepartmentAndSemester" method="get">
            <div class="form-group">
                <label for="department">Select Department:</label>
                <select class="form-control" id="department" name="department">
                    <option value="" selected>All Departments</option>
                    <c:forEach items="${departments}" var="department">
                        <option value="${department.id}">
                            ${department.name}
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
            <input type="submit" class="btn btn-primary" value="Show Courses">
        </form>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Course Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${courses}" var="course">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.name}</td>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${empty courses}">
                        <tr>
                            <td colspan="2" class="no-records">No records found!</td>
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
