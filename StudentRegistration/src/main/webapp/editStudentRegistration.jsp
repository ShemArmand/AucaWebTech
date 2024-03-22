<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student Registration</title>
    <!-- Add Bootstrap CSS or any other styles as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Edit Student Registration</h1>
        <form action="EditStudentRegistrationServlet" method="post">
            <input type="hidden" name="id" value="${studentRegistration.id}">
            
            <div class="form-group">
                <label for="studentId">Student:</label>
                <select id="studentId" name="studentId" class="form-control" required>
                    <c:forEach items="${students}" var="student">
                        <option value="${student.id}" ${student.id == studentRegistration.student.id ? 'selected' : ''}>${student.name}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="academicUnitId">Academic Unit:</label>
                <select id="academicUnitId" name="academicUnitId" class="form-control" required>
                    <c:forEach items="${academicUnits}" var="academicUnit">
                        <option value="${academicUnit.id}" ${academicUnit.id == studentRegistration.academicUnit.id ? 'selected' : ''}>${academicUnit.name}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="semesterId">Semester:</label>
                <select id="semesterId" name="semesterId" class="form-control" required>
                    <c:forEach items="${semesters}" var="semester">
                        <option value="${semester.id}" ${semester.id == studentRegistration.semester.id ? 'selected' : ''}>${semester.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="registrationDate">Registration Date:</label>
                <input type="date" id="registrationDate" name="registrationDate" class="form-control" value="${studentRegistration.registrationDate}" required>
            </div>

            <div class="form-group">
                <label for="status">Status:</label>
                <select id="status" name="status" class="form-control" required>
                    <option value="PENDING" ${studentRegistration.status == 'PENDING' ? 'selected' : ''}>PENDING</option>
                    <option value="ADMITTED" ${studentRegistration.status == 'ADMITTED' ? 'selected' : ''}>ADMITTED</option>
                    <option value="REJECTED" ${studentRegistration.status == 'REJECTED' ? 'selected' : ''}>REJECTED</option>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Student Registration</button>
        </form>
    </div>
    
    <!-- Add Bootstrap JS (Optional) or any other scripts as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
