<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Table Test</title>
</head>
<body>
    <h1>Create Table Test</h1>

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