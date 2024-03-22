<!DOCTYPE html>
<html>
<head>
    <title>Sign Up - Student Registration Management System</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script>
        function validateForm() {
            const password = document.getElementById("password").value;
            const repeatPassword = document.getElementById("repeatPassword").value;
            const termsCheck = document.getElementById("termsCheck").checked;

            if (password !== repeatPassword) {
                alert("Passwords do not match.");
                return false;
            }

            if (!termsCheck) {
                alert("Please agree to the Terms of Service.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <section class="vh-100">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                    <div class="card" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                    <h1 class="text-center fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</h1>
                                    <form action="CreateRegistrarUserServlet" method="post" onsubmit="return validateForm()">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">
                                                        <i class="fas fa-user fa-fw"></i>
                                                    </span>
                                                </div>
                                                <input type="text" class="form-control" name="registrarNames" placeholder="Your Name" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">
                                                        <i class="fas fa-envelope fa-fw"></i>
                                                    </span>
                                                </div>
                                                <input type="text" class="form-control" name="registrarUserName" placeholder="Username" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">
                                                        <i class="fas fa-envelope fa-fw"></i>
                                                    </span>
                                                </div>
                                                <input type="text" class="form-control" name="registrarPhone" placeholder="Phone Number" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">
                                                        <i class="fas fa-lock fa-fw"></i>
                                                    </span>
                                                </div>
                                                <input type="password" class="form-control" name="registrarPassword" id="password" placeholder="Password" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">
                                                        <i class="fas fa-key fa-fw"></i>
                                                    </span>
                                                </div>
                                                <input type="password" class="form-control" id="repeatPassword" placeholder="Repeat your password" required>
                                            </div>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="termsCheck" required>
                                            <label class="form-check-label" for="termsCheck">
                                                I agree to the <a href="#!">Terms of Service</a>
                                            </label>
                                        </div>
                                        <div class="text-center mt-4">
                                            <button type="submit" class="btn btn-primary btn-lg">Register</button>
                                        </div>
                                    </form>
                                    <p class="mt-3">Already have an account? <a href="loginn.jsp">Login</a></p>
                                </div>
                                <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp" class="img-fluid" alt="Sample image">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Add Bootstrap JS (Optional) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
