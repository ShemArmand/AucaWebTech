<!DOCTYPE html>
<html>

<head>
    <title>Create Teacher</title>
    <!-- Include Bootstrap CSS or any other styles if desired -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>
    <div class="container mt-5">
        <h1 class="mb-4">Create Teacher</h1>
        <form action="CreateTeacherServlet" method="post">
            <div class="form-group">
                <label for="names">Teacher Names:</label>
                <input type="text" id="names" name="names" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="teach">Teaching Subject:</label>
                <input type="text" id="teach" name="teach" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="assistantTutor">Assistant Tutor:</label>
                <input type="text" id="assistantTutor" name="assistantTutor" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="qualification">Qualification:</label>
                <select id="qualification" name="qualification" class="form-control" required>
                    <option value="MASTER">Master</option>
                    <option value="PHD">PhD</option>
                    <option value="PROFESSOR">Professor</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Create Teacher</button>
        </form>
    </div>

    <!-- Include Bootstrap JS or any other scripts if needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
