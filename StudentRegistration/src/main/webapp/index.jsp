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
            background-color: rgba(0, 0, 0, 0.6); /* Add a semi-transparent background */
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
                    <a class="nav-link" href="student?action=listStudentsBySemester&semester">List Students by Semester</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="student?action=listStudentsByDepartmentAndSemester">List Students by Department and Semester</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getStudentsByCourseAndSemester">List Students by Course and Semester</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getCoursesByDepartmentAndSemester">List Course by Department and Semester</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getCoursesByStudent">List Course by Student</a>
                </li>
            </ul>
        </nav>

        <form action="ListStudentsServlet" method="get">
            <button type="submit" class="btn btn-secondary">List Students</button>
        </form>
        <form action="ListTeachersServlet" method="get">
            <button type="submit" class="btn btn-secondary">List Teachers</button>
        </form>
        <form action="ListCourseDefinitionsServlet" method="get">
            <button type="submit" class="btn btn-secondary">List Course Definition</button>
        </form>
        <form action="ListSemestersServlet" method="get">
            <button type="submit" class="btn btn-secondary">List Semester</button>
        </form>
        <form action="ListAcademicUnitsServlet" method="get">
            <button type="submit" class="btn btn-secondary">List Academic Unit</button>
        </form>
        <form action="ListStudentRegistrationsServlet" method="get">
            <button type="submit" class="btn btn-secondary">List Student Registrations</button>
        </form>
        <form action="ListCoursesServlet" method="get">
            <button type="submit" class="btn btn-secondary">List Courses</button>
        </form>
        <form action="ListStudentCoursesServlet" method="get">
            <button type="submit" class="btn btn-secondary">List Student Course</button>
        </form>

        <!-- Add the Logout button -->
        <form action="home.jsp" method="get">
            <button type="submit" class="btn btn-danger">Logout</button>
        </form>
    </div>

    <!-- Add Bootstrap JS (Optional) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
