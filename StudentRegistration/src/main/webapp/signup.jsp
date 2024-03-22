<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h2>Sign Up</h2>
    <form action="student" method="POST">
        <input type="hidden" name="action" value="signup">
        <label for="regNo">Registration Number:</label>
        <input type="text" name="regNo" id="regNo" required><br>
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" id="firstName" required><br>
        <label for="dateOfBirth">Date of Birth:</label>
        <input type="text" name="dateOfBirth" id="dateOfBirth" required><br>
        <input type="submit" value="Sign Up">
    </form>
</body>
</html>