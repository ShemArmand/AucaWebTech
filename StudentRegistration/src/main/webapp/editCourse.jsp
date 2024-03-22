<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Course</title>
    <!-- Add Bootstrap CSS or any other styles as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Edit Course</h1>
        <form action="EditCourseServlet" method="post">
            <input type="hidden" name="id" value="${course.id}">
            
            <div class="form-group">
                <label for="courseDefinitionId">Course Definition:</label>
                <select id="courseDefinitionId" name="courseDefinitionId" class="form-control" required>
                    <c:forEach items="${courseDefinitions}" var="definition">
                        <option value="${definition.id}" ${course.courseDefinition.id == definition.id ? 'selected' : ''}>${definition.name}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="academicUnitId">Academic Unit:</label>
                <select id="academicUnitId" name="academicUnitId" class="form-control" required>
                    <c:forEach items="${academicUnits}" var="unit">
                        <option value="${unit.id}" ${course.academicUnit.id == unit.id ? 'selected' : ''}>${unit.name}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="semesterId">Semester:</label>
                <select id="semesterId" name="semesterId" class="form-control" required>
                    <c:forEach items="${semesters}" var="semester">
                        <option value="${semester.id}" ${course.semester.id == semester.id ? 'selected' : ''}>${semester.name}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="teacherId">Teacher:</label>
                <select id="teacherId" name="teacherId" class="form-control" required>
                    <c:forEach items="${teachers}" var="teacher">
                        <option value="${teacher.code}" ${course.teacher.code == teacher.code ? 'selected' : ''}>${teacher.names}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="assistantTutorId">Assistant Tutor:</label>
                <select id="assistantTutorId" name="assistantTutorId" class="form-control">
                    <option value="" ${empty course.assistantTutor ? 'selected' : ''}>None</option>
                    <c:forEach items="${teachers}" var="teacher">
                        <option value="${teacher.code}" ${!empty course.assistantTutor && course.assistantTutor.code == teacher.code ? 'selected' : ''}>${teacher.names}</option>
                    </c:forEach>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Course</button>
        </form>
    </div>
    
    <!-- Add Bootstrap JS (Optional) or any other scripts as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
