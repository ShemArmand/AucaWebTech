<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Course" %>
<%@ page import="model.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses by Student</title>
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
        <h1>Courses by Student</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Course Name</th>
                    <th>Academic Unit</th>
                    <th>Semester</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${courses}" var="course">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.courseDefinition.name}</td>
                        <td>${course.academicUnit.name}</td>
                        <td>${course.semester.name}</td>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${empty courses}">
                        <tr>
                            <td colspan="4" class="no-records">No records found!</td>
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
