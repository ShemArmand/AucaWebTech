<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Create Course</title>
    <!-- Include Bootstrap CSS or any other styles if desired -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h1 class="mb-4">Create Course</h1>
        <form action="CreateCourseServlet" method="post">
            <div class="form-group">
                <label for="courseDefinitionId">Course Definition:</label>
                <select id="courseDefinitionId" name="courseDefinitionId" class="form-control" required>
                    <option value="">Select a Course Definition</option>
                    <!-- Use JSTL to iterate through the course definitions -->
                    <c:forEach items="${courseDefinitions}" var="courseDefinition">
                        <option value="${courseDefinition.id}">${courseDefinition.name}</option>
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
                <label for="teacherId">Teacher:</label>
                <select id="teacherId" name="teacherId" class="form-control" required>
                    <option value="">Select a Teacher</option>
                    <!-- Use JSTL to iterate through the teachers -->
                    <c:forEach items="${teachers}" var="teacher">
                        <option value="${teacher.code}">${teacher.names}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="assistantTutorId">Assistant Tutor:</label>
                <select id="assistantTutorId" name="assistantTutorId" class="form-control" required>
                    <option value="">Select an Assistant Tutor</option>
                    <!-- Use JSTL to iterate through the assistant tutors -->
                    <c:forEach items="${teachers}" var="assistantTutor">
                        <option value="${assistantTutor.code}">${assistantTutor.names}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Create Course</button>
        </form>
    </div>

    <!-- Include Bootstrap JS or any other scripts if needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
