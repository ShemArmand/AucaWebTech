<!DOCTYPE html>
<html>
<head>
    <title>Edit Course Definition</title>
    <!-- Add Bootstrap CSS or any other styles as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Edit Course Definition</h1>
        <form action="EditCourseDefinitionServlet" method="post">
            <input type="hidden" name="id" value="${courseDefinition.id}">
            
            <div class="form-group">
                <label for="code">Code:</label>
                <input type="text" id="code" name="code" class="form-control" value="${courseDefinition.code}" required>
            </div>
            
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" class="form-control" value="${courseDefinition.name}" required>
            </div>
            
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" class="form-control" required>${courseDefinition.description}</textarea>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Course Definition</button>
        </form>
    </div>
    
    <!-- Add Bootstrap JS (Optional) or any other scripts as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
