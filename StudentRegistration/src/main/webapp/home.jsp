<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="Styles/styles.css">
    <title>AUCA-Home</title>
    <style>
        h3 {
            margin: 0px;
            padding-top: 100px;
            color: white;
            font-size: 50px;
        }

        .p {
            color: white;
            font-size: 20px;
            font-style: bold;
        }
        body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

header {
    background-color: #224560;
    color: #fff;
    text-align: center;
    padding: 20px;
}

nav {
    background-color: #224560;
    color: #fff;
    text-align: center;
    font-size: 20px;
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

nav li {
    display: inline;
    margin: 10px;
}

nav a {
    text-decoration: none;
    color: #fff;
}

main {
    text-align: center;
    padding-bottom: 450px;
}

.background-image {
    background-image: url('Images/Campuses.png');
    background-size: cover;
    height: 800px;
}

.messageformbackground {
    background-color: #224560;
    color: #fff;
    padding: 20px;
}

footer {
    background-color: #224560;
    color: yellow;
    text-align: center;
    padding: 10px;
}

#about {
    padding: 50px;
    padding-bottom: 520px;
}

.department {
    padding: 20px;
    padding-bottom: 480px;
    justify-content: center;
    background-color: #0066cc;
    color: white;
    font-size: 25px;
}

.department table {
    width: 100%;
    border-collapse: collapse;
}

.department table,
.department th,
.department td {
    border: 1px solid #fff;
}

.department th,
.department td {
    padding: 8px;
    text-align: left;
}
.gallery {
    text-align: center;
    padding-bottom: 10px;
  }
  .gallery img {
    margin: 10px;
  }
form label, form input, form textarea, form button {
    display: block;
    margin-bottom: 10px;
    max-width: 300px;
    margin: 20px auto;
    background-color: #fff;
}
form{
    margin: 0px;
    padding-bottom: 50px;
    margin-block: 60px;
}
/* Container for the slider */
.slider-container {
    width: 80%;
    height: 100%;
    margin: 0 auto;
    overflow: hidden;
}

/* Slide container to hold individual slides */
.slide-container {
    display: flex;
    transition: transform 0.5s ease;
}

/* Individual slide */
.slide {
    min-width: 100%;
}

/* Buttons for navigation */
.slider-button {
    cursor: pointer;
}

button {
    font-size: 50px;
}
        
    </style>
</head>

<body>
    <header>
        <img src="images/pic3.png" alt="Image 1">
        <h1>Welcome to the Student Registration Management System</h1>
    </header>

    

    <main>
        <section id="home">
            
            <div class="container">
        <h1>Manage your student registrations with ease.</h1>
        <form action="loginn.jsp">
            <button class="btn btn-primary login-button" type="submit">Login</button>
        </form>
    </div>


        </section>



    </main>

    <footer>
        <p>&copy; Kayiranga Shema Armand 23729</p>
    </footer>
</body>

</html>