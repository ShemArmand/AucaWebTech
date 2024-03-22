<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>All Student Courses</title>
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
        <h1>All Student Courses</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Course Name</th>
                <th>Student Name</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${studentCourses}" var="studentCourse">
                <tr id="studentCourseRow_${studentCourse.id}">
                    <td>${studentCourse.id}</td>
                    <td>${studentCourse.course.courseDefinition.name}</td>
                    <td>${studentCourse.studentRegistration.student.name}</td>
                    <td class="actions">
                        <a href="EditStudentCourseServlet?id=${studentCourse.id}" class="btn btn-primary">Edit</a>
                        <a href="<c:url value='/DeleteStudentCourseServlet?id=${studentCourse.id}' />"
                           class="btn btn-danger"
                           onclick="confirmDelete(${studentCourse.id})">Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="CreateStudentCourseServlet" method="get">
            <button type="submit" class="btn btn-primary">Create Student Course</button>
        </form>
    </div>

    <script>
        function confirmDelete(courseId) {
            var confirmation = confirm("Are you sure you want to delete this student course?");
            if (confirmation) {
                window.location.href = '<c:url value="/DeleteStudentCourseServlet?id=' + courseId + '" />';
            }
        }
    </script>
</body>
</html>
