<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Create Academic Unit</title>
    <!-- Include Bootstrap CSS or any other styles if desired -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h1 class="mb-4">Create Academic Unit</h1>
        <form action="CreateAcademicUnitServlet" method="post">
            <div class="form-group">
                <label for="code">Academic Unit Code:</label>
                <input type="text" id="code" name="code" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="name">Academic Unit Name:</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="parentUnit">Select an Existing Parent Unit:</label>
                <select id="parentUnitId" name="parentUnitId" class="form-control">
                    <option value="">Select a Parent Unit</option>
                    <!-- Use JSTL to iterate through the parent units -->
                    <c:forEach items="${parentUnits}" var="parentUnit">
                        <option value="${parentUnit.id}">${parentUnit.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="academicType">Academic Type:</label>
                <select id="academicType" name="academicType" class="form-control" required>
                    <option value="PROGRAMME">Programme</option>
                    <option value="FACULTY">Faculty</option>
                    <option value="DEPARTMENT">Department</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Create Academic Unit</button>
        </form>
    </div>

    <!-- Include Bootstrap JS or any other scripts if needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
