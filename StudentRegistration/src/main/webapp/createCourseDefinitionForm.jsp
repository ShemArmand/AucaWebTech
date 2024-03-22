<!DOCTYPE html>
<html>
<head>
    <title>Create Course Definition</title>
    <!-- Include any CSS or Bootstrap if desired -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Create Course Definition</h1>
        <form action="CreateCourseDefinitionServlet" method="post">
            <div class="form-group">
                <label for="code">Course Code:</label>
                <input type="text" id="code" name="code" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="name">Course Name:</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="description">Course Description:</label>
                <textarea id="description" name="description" class="form-control" required></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Create Course Definition</button>
        </form>
    </div>

    <!-- Include any JavaScript or Bootstrap JS if needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
