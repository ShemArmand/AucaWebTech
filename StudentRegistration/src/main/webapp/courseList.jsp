<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<head>
    <title>Create Table Test</title>
</head>
<body>
    <h1>Create Table Test</h1>
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
    

    <%@ page import="org.hibernate.SessionFactory, org.hibernate.cfg.Configuration" %>
    <%@ page import="util.HibernateUtil" %>

    <%-- Create the Hibernate configuration and session factory --%>
    <% Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); %>
    <%@ page import="model.AcademicUnit" %>
    <% configuration.addAnnotatedClass(AcademicUnit.class); %>
    <% SessionFactory sessionFactory = configuration.buildSessionFactory(); %>

    <p>The table has been created successfully.</p>

    <%-- Close the session factory to release resources --%>
    <% sessionFactory.close(); %>
</body>
</html>