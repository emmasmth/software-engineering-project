<%--
  Created by IntelliJ IDEA.
  User: oliverkochpaiz
  Date: 10/21/23
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="model.entity.User" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <jsp:include page="components/header.jsp"/>
</head>
<body>
<jsp:include page="components/title.jsp"/>
<jsp:include page="components/menu.jsp"/>

<div class="container">
  <h2 class="text-center offset-1 text-info">Registration</h2>

  <% User logged = (User) session.getAttribute("User"); %>
  <% if (logged != null)
  { %>
      <h3 class="text-center offset-1" style="color: red">You are already registered and logged in!</h3>
  <%
  }
  else
  {
  %>

  <form method="post" action="RegistrationServlet">

    <div class="row justify-content-center mb-1">
      <label class="col-1" for="name">Name: </label>
      <div class="col-4">
        <input class="form-control " type="text" id="name" name="name"/>
      </div>
    </div>


    <div class="row justify-content-center mb-1">
      <label class="col-1" for="username">Email: </label>
      <div class="col-4">
        <input class="form-control" type="email" id="username" name="username"/>
      </div>
    </div>

    <div class="row justify-content-center mb-1">
      <label class="col-1" for="pass">Password: </label>
      <div class="col-4">
        <input class="form-control" type="password" id="pass" name="password"/>
      </div>
    </div>

    <div class="row justify-content-center">
      <div class="col-1 mt-3 offset-1 d-grid">
        <button class="btn btn-outline-primary" type="submit">Register</button>
      </div>

      <div class="col-1 mt-3 d-grid">
        <button class="btn btn-outline-secondary" type="reset">Clear</button>
      </div>

      <div class="col-1 mt-3 d-grid">
        <a class="btn btn-outline-info" href="index.jsp">Home</a>
      </div>
    </div>



  </form>
  <% } %>



</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>