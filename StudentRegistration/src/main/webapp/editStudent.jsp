<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <!-- Add Bootstrap CSS or any other styles as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Edit Student</h1>
        <form action="EditStudentServlet" method="post">
            <input type="hidden" name="id" value="${student.id}">
            
            <div class="form-group">
                <label for="regNo">Registration Number:</label>
                <input type="text" id="regNo" name="regNo" class="form-control" value="${student.regNo}" required>
            </div>
            
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" class="form-control" value="${student.name}" required>
            </div>
            
            <div class="form-group">
                <label for="dateOfBirth">Date of Birth:</label>
                <input type="date" id="dateOfBirth" name="dateOfBirth" class="form-control" value="${student.dateOfBirth}" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Student</button>
        </form>
    </div>
    
    <!-- Add Bootstrap JS (Optional) or any other scripts as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
