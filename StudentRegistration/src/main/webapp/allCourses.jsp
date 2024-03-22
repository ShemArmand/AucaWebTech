<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>All Courses</title>
    <link rel="stylesheet" href="your-styles.css"> <!-- Add your custom styles -->
    <style>
        /* Add any inline styles if needed */
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f5f5f5;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .actions {
            display: flex;
            justify-content: space-between;
        }

        .btn {
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .btn-primary {
            background-color: #007bff;
            color: #fff;
        }

        .btn-danger {
            background-color: #dc3545;
            color: #fff;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1>All Courses</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Course Definition</th>
                <th>Academic Unit</th>
                <th>Semester</th>
                <th>Teacher</th>
                <th>Assistant Tutor</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${courses}" var="course">
                <tr id="courseRow_${course.id}">
                    <td>${course.id}</td>
                    <td>${course.courseDefinition.name}</td>
                    <td>${course.academicUnit.name}</td>
                    <td>${course.semester.name}</td>
                    <td>${course.teacherName}</td>
                    <td>${course.assistantTutorName}</td>
                    <td class="actions">
                        <a href="EditCourseServlet?id=${course.id}" class="btn btn-primary">Edit</a>
                        <a href="<c:url value='/DeleteCourseServlet?id=${course.id}' />"
                           class="btn btn-danger"
                           onclick="confirmDelete(${course.id})">Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="CreateCourseServlet" method="get">
            <button type="submit" class="btn btn-primary">Create Course</button>
        </form>
    </div>

    <script>
        function confirmDelete(courseId) {
            var confirmation = confirm("Are you sure you want to delete this course?");
            if (confirmation) {
                // If the user confirms, redirect to the DeleteCourseServlet
                window.location.href = '<c:url value="/DeleteCourseServlet?id=' + courseId + '" />';
            }
        }
    </script>
</body>

</html>
