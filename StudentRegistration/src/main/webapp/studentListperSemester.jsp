<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="util.HibernateUtil" %>
<%@ page import="model.Student" %>
<%@ page import="control.StudentController" %>
<%@ page import="ServiceImp.StudentServiceImpl" %>
<%@ page import="dao.StudentDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
 
%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Students per Semester</title>
</head>
<body>
   <h1>Students per Semester</h1>
   <table>
      <thead>
         <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Department</th>
         </tr>
      </thead>
      <tbody>
        Students
      </tbody>
   </table>
</body>
</html>