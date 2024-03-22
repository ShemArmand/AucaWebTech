<!DOCTYPE html>
<html>
<head>
    <title>Edit Teacher</title>
    <!-- Add Bootstrap CSS or any other styles as needed -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Edit Teacher</h1>
        <form action="EditTeacherServlet" method="post">
            <input type="hidden" name="code" value="${teacher.code}">
            
            <div class="form-group">
                <label for="names">Names:</label>
                <input type="text" id="names" name="names" class="form-control" value="${teacher.names}" required>
            </div>
            
            <div class="form-group">
                <label for="teach">Teach:</label>
                <input type="text" id="teach" name="teach" class="form-control" value="${teacher.teach}" required>
            </div>
            
            <div class="form-group">
                <label for="assistantTutor">Assistant Tutor:</label>
                <input type="text" id="assistantTutor" name="assistantTutor" class="form-control" value="${teacher.assistantTutor}" required>
            </div>
            
            <div class="form-group">
                <label for="qualification">Qualification:</label>
                <select id="qualification" name="qualification" class="form-control" required>
                    <option value="MASTER" ${teacher.qualification == 'MASTER' ? 'selected' : ''}>MASTER</option>
                    <option value="PHD" ${teacher.qualification == 'PHD' ? 'selected' : ''}>PHD</option>
                    <option value="PROFESSOR" ${teacher.qualification == 'PROFESSOR' ? 'selected' : ''}>PROFESSOR</option>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Teacher</button>
        </form>
    </div>
    
    <!-- Add Bootstrap JS (Optional) or any other scripts as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
