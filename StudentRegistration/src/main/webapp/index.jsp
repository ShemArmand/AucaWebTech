<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-image: url(/images/pic2.jpg);
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            color: #ffffff; /* Text color */
        }

        .container {
            padding: 40px;
            background-color: rgba(45, 38, 164, 0.85); /* Add a semi-transparent background */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        .navbar {
            margin-top: 20px;
        }

        .btn {
            margin-top: 10px;
        }

        h1 {
            text-align: center;
            margin-top: 30px;
            color: #ffffff; /* Text color */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Student Management System</h1>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="ListStudentsServlet">List of Students</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListTeachersServlet">List of Teachers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListCourseDefinitionsServlet">Course Definition</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListSemestersServlet">Semesters</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListAcademicUnitsServlet">Academic units</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListCoursesServlet">Courses</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListStudentRegistrationsServlet">Student Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ListStudentCoursesServlet">Student per course</a>
                </li>
            </ul>
        </nav>

                <!-- Add the Logout button -->
        <form action="home.jsp" method="get">
            <button type="submit" class="btn btn-danger">Logout</button>
        </form>
    </div>

    <!-- Add Bootstrap JS (Optional) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
