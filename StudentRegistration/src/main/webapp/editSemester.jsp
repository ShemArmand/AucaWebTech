<!DOCTYPE html>
<html>
<head>
    <title>Edit Semester</title>
    <!-- Add Bootstrap CSS or any other styles as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Edit Semester</h1>
        <form action="EditSemesterServlet" method="post">
            <input type="hidden" name="id" value="${semester.id}">
            
            <div class="form-group">
                <label for="name">Semester Name:</label>
                <input type="text" id="name" name="name" class="form-control" value="${semester.name}" required>
            </div>
            
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" class="form-control" value="${semester.startDate}" required>
            </div>
            
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" class="form-control" value="${semester.endDate}" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Semester</button>
        </form>
    </div>
    
    <!-- Add Bootstrap JS (Optional) or any other scripts as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
