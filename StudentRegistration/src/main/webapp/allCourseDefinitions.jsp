<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<head>
    <title>All Course Definitions</title>
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
        <h1>All Course Definitions</h1>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color:#2980B9 ">

            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="ListStudentsServlet">List of Students</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListTeachersServlet">List of Teachers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListCourseDefinitionsServlet">Course Definition</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListSemestersServlet">Semesters</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListAcademicUnitsServlet">Academic units</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListCoursesServlet">Courses</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListStudentRegistrationsServlet">Student Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListStudentCoursesServlet">Student per course</a>
                </li>
               
            </ul>
             <span class="navbar-text">
                <form action="loginn.jsp" method="get">
                <button type="submit" class="btn btn-danger">Logout</button>
       			</form>
                </span>


        </nav>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Name</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${courseDefinitions}" var="courseDefinition">
                <tr id="courseDefinitionRow_${courseDefinition.id}">
                    <td>${courseDefinition.id}</td>
                    <td>${courseDefinition.code}</td>
                    <td>${courseDefinition.name}</td>
                    <td>${courseDefinition.description}</td>
                    <td class="actions">
                        <a href="EditCourseDefinitionServlet?id=${courseDefinition.id}" class="btn btn-primary">Edit</a>
                        <a href="<c:url value='/DeleteCourseDefinitionServlet?id=${courseDefinition.id}' />"
                           class="btn btn-danger"
                           onclick="confirmDelete(${courseDefinition.id}, '${courseDefinition.code}')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="CreateCourseDefinitionServlet" method="get">
            <button type="submit" class="btn btn-primary">Create Course Definition</button>
        </form>
    </div>

    <script>
        function confirmDelete(courseDefinitionId, courseDefinitionCode) {
            var confirmation = confirm("Are you sure you want to delete the course definition with code: " + courseDefinitionCode + "?");
            if (confirmation) {
                // If the user confirms, redirect to the DeleteCourseDefinitionServlet
                window.location.href = '<c:url value="/DeleteCourseDefinitionServlet?id=' + courseDefinitionId + '" />';
            }
        }
    </script>
</body>
</html>
