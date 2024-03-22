<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Create Student Registration</title>
    <!-- Include Bootstrap CSS or any other styles if desired -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h1 class="mb-4">Create Student Registration</h1>
        <form action="CreateStudentRegistrationServlet" method="post">
            <div class="form-group">
                <label for="studentId">Student:</label>
                <select id="studentId" name="studentId" class="form-control" required>
                    <option value="">Select a Student</option>
                    <!-- Use JSTL to iterate through the students -->
                    <c:forEach items="${students}" var="student">
                        <option value="${student.id}">${student.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="academicUnitId">Academic Unit:</label>
                <select id="academicUnitId" name="academicUnitId" class="form-control" required>
                    <option value="">Select an Academic Unit</option>
                    <!-- Use JSTL to iterate through the academic units -->
                    <c:forEach items="${academicUnits}" var="academicUnit">
                        <option value="${academicUnit.id}">${academicUnit.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="semesterId">Semester:</label>
                <select id="semesterId" name="semesterId" class="form-control" required>
                    <option value="">Select a Semester</option>
                    <!-- Use JSTL to iterate through the semesters -->
                    <c:forEach items="${semesters}" var="semester">
                        <option value="${semester.id}">${semester.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="registrationDate">Registration Date:</label>
                <input type="date" id="registrationDate" name="registrationDate" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="status">Status:</label>
                <select id="status" name="status" class="form-control" required>
                    <option value="">Select a Status</option>
                    <option value="PENDING">PENDING</option>
                    <option value="ADMITTED">ADMITTED</option>
                    <option value="REJECTED">REJECTED</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Create Student Registration</button>
        </form>
    </div>

    <!-- Include Bootstrap JS or any other scripts if needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
