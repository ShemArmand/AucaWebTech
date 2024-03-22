<!DOCTYPE html>
<html>

<head>
    <title>Create Semester</title>
    <!-- Include Bootstrap CSS or any other styles if desired -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h1 class="mb-4">Create Semester</h1>
        <form action="CreateSemesterServlet" method="post">
            <div class="form-group">
                <label for="name">Semester Name:</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Create Semester</button>
        </form>
    </div>

    <!-- Include Bootstrap JS or any other scripts if needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
