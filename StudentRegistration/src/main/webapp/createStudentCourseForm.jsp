<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Create Student Course</title>
    <!-- Include Bootstrap CSS or any other styles if desired -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h1 class="mb-4">Create Student Course</h1>
        <form action="CreateStudentCourseServlet" method="post">
            <div class="form-group">
                <label for="courseId">Select a Course:</label>
                <select id="courseId" name="courseId" class="form-control" required>
                    <option value="">Select a Course</option>
                    <!-- Use JSTL to iterate through the courses -->
                    <c:forEach items="${courses}" var="course">
                        <option value="${course.id}">${course.courseDefinition.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="studentRegistrationId">Select a Student Registration:</label>
                <select id="studentRegistrationId" name="studentRegistrationId" class="form-control" required>
                    <option value="">Select a Student Registration</option>
                    <!-- Use JSTL to iterate through the student registrations -->
                    <c:forEach items="${studentRegistrations}" var="studentRegistration">
                        <option value="${studentRegistration.id}">${studentRegistration.student.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="credits">Credits:</label>
                <input type="number" id="credits" name="credits" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="result">Result:</label>
                <input type="number" step="0.01" id="result" name="result" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Create Student Course</button>
        </form>
    </div>

    <!-- Include Bootstrap JS or any other scripts if needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
