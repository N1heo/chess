<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Registration</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/registration.css">

  <link rel="icon" type="image/x-icon" href="https://st-1.akipress.org/st_all/bilim/9/1519540999.2.jpg">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous" defer></script>
</head>

<body>  

  <section id="registration">
    <div class="container mt-4 pt-4">
      <div class="row mt-4 justify-content-md-center text-center">
        <div class="col-lg-6">
          <form:form method="POST" modelAttribute="userForm">
            <h2>Registration</h2>
            <div id="username">
              <form:input type="text" path="username" placeholder="Username"
                          autofocus="true"></form:input>
              <form:errors path="username"></form:errors>
                ${usernameError}
            </div>
            <div id="password">
              <form:input type="password" path="password" placeholder="Password"></form:input>
            </div>
            <div id="passwordConf">
              <form:input type="password" path="passwordConfirm"
                          placeholder="Confirm your password"></form:input>
              <form:errors path="password"></form:errors>
                ${passwordError}
            </div>
            <button id="button" type="submit">Register</button>
          </form:form>
        </div>
        <a href="/">Main page</a>
      </div>
    </div>

    

  </section>
<div>
  
</div>

</body>
</html>
