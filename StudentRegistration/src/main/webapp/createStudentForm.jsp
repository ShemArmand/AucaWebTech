<!DOCTYPE html>
<html>

<head>
    <title>Create Student</title>
    <!-- Add Bootstrap CSS or any other styles as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h1 class="mb-4">Create Student</h1>
        <form action="CreateStudentServlet" method="post">
            <div class="form-group">
                <label for="regNo">Registration Number:</label>
                <input type="text" id="regNo" name="regNo" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="dateOfBirth">Date of Birth:</label>
                <input type="date" id="dateOfBirth" name="dateOfBirth" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Create Student</button>
        </form>
    </div>

    <!-- Add Bootstrap JS (Optional) or any other scripts as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
