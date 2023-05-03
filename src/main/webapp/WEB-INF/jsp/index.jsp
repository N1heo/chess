<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Main page</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/index.css">

  <link rel="icon" type="image/x-icon" href="https://st-1.akipress.org/st_all/bilim/9/1519540999.2.jpg">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous" defer></script>
</head>
<body class="d-flex flex-column min-vh-100">
  <nav class="navbar navbar-expand-lg fixed-top navbarScroll">
    <div class="container-fluid">
        <img src="https://st-1.akipress.org/st_all/bilim/9/1519540999.2.jpg" class="imageAlaToo" width="50" height="50"/>
    </div>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto">
            <sec:authorize access="hasRole('ADMIN')">
                <li class="nav-item">
                    <a id="admin" class="nav-link" href="/admin"><b>Admin</b></a>  
                </li>
            </sec:authorize>
            
            <li class="nav-item">
                <a id="order" class="nav-link" href="/order"><b>Order</b></a>  
            </li>

            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a id="login" class="nav-link" href="/login"><b>Login</b></a>
                </li>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a id="login" class="nav-link" href="/logout"><b>LogOut</b></a>
                </li>
            </sec:authorize>

            <li class="nav-item">
              <a id="registration" class="nav-link" href="/registration"><b>Register</b></a>
            </li>
            
        </ul>
        
    </div>
</nav>

<section id="main">
    <div class="container mt-4 pt-4">
        <div class="row mt-4 justify-content-md-center text-center">
            <h1 class="text-center">AIU Merch</h1>
            <div class="col-lg-6">
                <sec:authorize access="!isAuthenticated()">
                    <p> Hello, stranger!</p>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <p> Hello, ${pageContext.request.userPrincipal.name}!</p>
                </sec:authorize>
                
                <p id="description"> Here you can order the merch of AlaToo International University. </p>
            </div>
        </div>
    </div>
</section>
<!-- <img src="${contextPath}/resources/images/shirt.png" class="shirtImage" alt="Not found"/> -->

<section id="catalog">
    <div class="container mt-4 pt-4">
        <h2 class="text-center">Catalog</h2>
        <div class="row mt-4 justify-content-md-center text-center">
            <div class="col-lg-4">
                <div id="carouselItems" class="carousel carousel-dark slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                      <button type="button" data-bs-target="#carouselItems" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                      <button type="button" data-bs-target="#carouselItems" data-bs-slide-to="1" aria-label="Slide 2"></button>
                      <button type="button" data-bs-target="#carouselItems" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img src="${contextPath}/resources/images/shirt.png" class="d-block w-100" alt="...">
                      </div>
                      <div class="carousel-item">
                        <img src="${contextPath}/resources/images/longsleeve.png" class="d-block w-100" alt="...">
                      </div>
                      <div class="carousel-item">
                        <img src="${contextPath}/resources/images/notebook.png" class="d-block w-100" alt="...">
                      </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselItems" data-bs-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselItems" data-bs-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="visually-hidden">Next</span>
                    </button>
                  </div>
            </div>
        </div>
    </div>
</section>

<footer id="footer" class="mt-auto">
    <div class="container-fluid">
        <div class="row align-items-end">
            <div class="col">
                <p class="text-start" id="number"></p>
            </div>
            <div class="col">
                <p class="text-mid" id="gmail"></p>
            </div>
            <div class="col">
                <p class="text-end mt-auto" id="copyright">&copy; 2022 Capybara International</p>
            </div>
        </div>
    </div>
</footer>

</body>
</html>