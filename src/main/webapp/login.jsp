<%-- 
    Document   : login
    Created on : 03-10-2017, 09:50:51
    Author     : Oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Cupcake Project</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet">

    </head>

    <body>

        <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Cupcake Project</div>
        <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Nørgaardsvej 30 | Lyngby, 2800</div>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
            <div class="container">
                <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="index.html">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="about.html">About</a>
                        </li>
                        <li class="nav-item active px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="login.jsp">Login</a>
                        </li>
                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="contact.html">Contact</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">

            <div class="bg-faded p-4 my-4">
                <div class="card card-inverse">
                    <img class="card-img img-fluid w-100" src="img/slide-1.jpg" alt="">
                    <div class="card-img-overlay bg-overlay">
                        <h2 class="card-title text-shadow text-white text-uppercase mb-0">Login</h2>
                        <br>
                        <form action="UserServlet">
                            <h4 class="card-title text-shadow text-white text-uppercase mb-0">User name:</h4>
                            <input type="hidden" name="action" value="login">
                            <input type="text" name="name" id="uname">
                            <br>
                            <br>
                            <h4 class="card-title text-shadow text-white text-uppercase mb-0">Password:</h4>
                            <input type="password" name="password" id="password">
                            <br>
                            <br>
                            <input class="btn btn-secondary" type="submit" value="Login">
                        </form>
                    </div>
                </div>
            </div>

            <div class="bg-faded p-4 my-4">
                <div class="card card-inverse">
                    <img class="card-img img-fluid w-100" src="img/slide-2.jpg" alt="">
                    <div class="card-img-overlay bg-overlay">
                        <h2 class="card-title text-shadow text-white text-uppercase mb-0">Register</h2>
                        <br>
                        <form action="UserServlet">
                            <h4 class="text-shadow text-white">User Name:</h4>
                            <input type="hidden" name="action" value="register">
                            <input type="text" name="name">
                            <br>
                            <br>
                            <h4 class="text-shadow text-white">Password:</h4>
                            <input type="password" name="password">
                            <br>
                            <br>
                            <h4 class="text-shadow text-white">Email:</h4>
                            <input type="email" name="email">
                            <br>
                            <br>
                            <h4 class="text-shadow text-white">Balance:</h4>
                            <input type="text" name="balance"><br>
                            <br>
                            <br>
                            <input class="btn btn-secondary" type="submit" value="Register">
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->

        <footer class="bg-faded text-center py-5">
            <div class="container">
                <p class="m-0">Copyright &copy; CupcakeProject 2017</p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    </body>

</html>
