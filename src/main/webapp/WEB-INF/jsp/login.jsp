<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/login.css">

  <link rel="icon" type="image/x-icon" href="https://st-1.akipress.org/st_all/bilim/9/1519540999.2.jpg">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous" defer></script>
</head>

<body>
<sec:authorize access="isAuthenticated()">
  <% response.sendRedirect("/"); %>
</sec:authorize>

  <section id="login">
    <div class="container mt-4 pt-4">
      <div class="row mt-4 justify-content-md-center text-center">
        <h1 class="text-center">Log In</h1>
        <div class="col-lg-6">
          <form method="POST" action="/login">
            <div id="username">
              <input name="username" type="text" placeholder="Username" autofocus="true"/>
            </div>
            <div id="password">
              <input name="password" type="password" placeholder="Password"/>
            </div>
            <div id="sumbitLogin">
              <button type="submit">Log In</button>
            </div>
            <div id="registerButton">
              <h4><a href="/registration">Register</a></h4>
            </div>
              
          </form>
        </div>
      </div>
    </div>

    

  </section>
<div>
  
</div>

</body>
</html>
