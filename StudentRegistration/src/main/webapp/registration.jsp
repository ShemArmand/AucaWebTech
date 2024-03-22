<!-- registration.jsp -->
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <h2>Student Registration Form</h2>
    <form action="register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="registrationDate">Registration Date:</label>
        <input type="date" id="registrationDate" name="registrationDate" required><br>
        
        <label for="academicUnit">Academic Unit:</label>
        <select id="academicUnit" name="academicUnit" required>
            <!-- Add options for academic units here -->
        </select><br>
        
        <label for="semester">Semester:</label>
        <select id="semester" name="semester" required>
            <!-- Add options for semesters here -->
        </select><br>
        
        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="PENDING">Pending</option>
            <option value="ADMITTED">Admitted</option>
            <option value="REJECTED">Rejected</option>
        </select><br>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>