<%--
  Created by IntelliJ IDEA.
  User: oliverkochpaiz
  Date: 10/21/23
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<a href="hello-servlet">Hello Servlet</a>

<div class="container">
  <h2 class="text-center offset-1 text-info">Registration</h2>
  <form>

    <div class="row justify-content-center mb-1">
      <label class="col-1" for="name">Name: </label>
      <div class="col-4">
        <input class="form-control " type="text" id="name"/>
      </div>
    </div>


    <div class="row justify-content-center mb-1">
      <label class="col-1" for="username">Email: </label>
      <div class="col-4">
        <input class="form-control" type="email" id="username"/>
      </div>
    </div>

    <div class="row justify-content-center mb-1">
      <label class="col-1" for="pass">Password: </label>
      <div class="col-4">
        <input class="form-control" type="password" id="pass"/>
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
        <button class="btn btn-outline-info" type="button" href="">Home</button>
      </div>
    </div>



  </form>




</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</body>
</html>