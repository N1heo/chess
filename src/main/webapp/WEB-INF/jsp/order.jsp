<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Order</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/order.css">

    <link rel="icon" type="image/x-icon" href="https://st-1.akipress.org/st_all/bilim/9/1519540999.2.jpg">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous" defer></script>
</head>
<body>
  <section id="makeOrder">
    <div class="container mt-4 pt-4">
        <div class="row mt-4 justify-content-md-center text-center">

          <h2 class="text-center">Make an order: </h2>
          <div class="col-lg-6">
            <form action="/order" method="post">
              <select name="id" id="product">
                <option value="3">T-shirt</option>
                <option value="1">Longsleeve</option>
                <option value="2">Notebook</option>
              </select>
              <input id="inputAmount" type="text" name="amount" placeholder="Enter amount: ">
        
              <input id="submitBtn" type="submit" class="btn btn-primary" value="Order">
            </form>
          </div>
        </div>
    </div>
  </section>
  

  <section id="table">
    <table class="table" id="myTable">
      <thead>
      <tr id="headerRow">
          <th scope="col">#Id</th>
          <th scope="col">Product</th>
          <th scope="col">Amount</th>
          <th scope="col">Price</th>
      </tr>
      </thead>
      <tbody>
        <c:forEach items="${cartItems}" var="cartItem">
          <tr>
            <td>${cartItem.id}</td>
            <td>${cartItem.product_name}</td>
            <td>${cartItem.amount}</td>
            <td>${cartItem.price}</td>
          </tr>
        </c:forEach>
      </tbody>
  </table>
  </section>
  
  <section id="logout">
    <div class="row mt-4 justify-content-md-right text-center">
      <form th:action="@{/logout}" method="post">
        <p class="float-start" ><a href="/">Home</a></p>
      </form>
    </div>
  </section>
</body>
</html>
