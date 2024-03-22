<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Academic Unit</title>
    <!-- Add Bootstrap CSS or any other styles as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Edit Academic Unit</h1>
        <form action="EditAcademicUnitServlet" method="post">
            <input type="hidden" name="id" value="${academicUnit.id}">
            
            <div class="form-group">
                <label for="code">Code:</label>
                <input type="text" id="code" name="code" class="form-control" value="${academicUnit.code}" required>
            </div>
            
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" class="form-control" value="${academicUnit.name}" required>
            </div>
            
            <div class="form-group">
    <label for="parentUnit">Parent Unit:</label>
    <select id="parentUnitId" name="parentUnitId" class="form-control">
        <option value="" ${academicUnit.parentUnit == null ? 'selected' : ''}>None</option>
        <c:forEach items="${parentUnits}" var="parent">
            <option value="${parent.id}" ${academicUnit.parentUnit != null && academicUnit.parentUnit.id == parent.id ? 'selected' : ''}>${parent.name}</option>
        </c:forEach>
    </select>
</div>
            
            <div class="form-group">
                <label for="academicType">Academic Type:</label>
                <select id="academicType" name="academicType" class="form-control" required>
                    <option value="PROGRAMME" ${academicUnit.academicType == 'PROGRAMME' ? 'selected' : ''}>PROGRAMME</option>
                    <option value="FACULTY" ${academicUnit.academicType == 'FACULTY' ? 'selected' : ''}>FACULTY</option>
                    <option value="DEPARTMENT" ${academicUnit.academicType == 'DEPARTMENT' ? 'selected' : ''}>DEPARTMENT</option>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Academic Unit</button>
        </form>
    </div>
    
    <!-- Add Bootstrap JS (Optional) or any other scripts as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
