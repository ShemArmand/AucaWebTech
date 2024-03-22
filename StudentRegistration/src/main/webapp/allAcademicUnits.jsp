<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Academic Units</title>
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
        <h1>All Academic Units</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Name</th>
                <th>Parent Unit</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${academicUnits}" var="academicUnit">
                <tr id="academicUnitRow_${academicUnit.id}">
                    <td>${academicUnit.id}</td>
                    <td>${academicUnit.code}</td>
                    <td>${academicUnit.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${academicUnit.parentUnit != null}">
                                ${academicUnit.parentUnit.name}
                            </c:when>
                            <c:otherwise>
                                N/A
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${academicUnit.academicType}</td>
                    <td class="actions">
                        <a href="EditAcademicUnitServlet?id=${academicUnit.id}" class="btn btn-primary">Edit</a>
                        <a href="<c:url value='/DeleteAcademicUnitServlet?id=${academicUnit.id}' />" class="btn btn-danger" onclick="confirmDelete(${academicUnit.id})">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="CreateAcademicUnitServlet" method="get">
            <button type="submit" class="btn btn-primary">Create Academic Unit</button>
        </form>
    </div>

    <script>
        function confirmDelete(academicUnitId) {
            var confirmation = confirm("Are you sure you want to delete this academic unit?");
            if (confirmation) {
                // If the user confirms, redirect to the DeleteAcademicUnitServlet
                window.location.href = '<c:url value="/DeleteAcademicUnitServlet?id=' + academicUnitId + '" />';
                
            }
            else{
            	window.location.href = 'ListAcademicUnitsServlet';
            }
        }
    </script>
</body>
</html>
