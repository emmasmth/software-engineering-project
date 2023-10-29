<%--
  Created by IntelliJ IDEA.
  User: oliverkochpaiz
  Date: 10/29/23
  Time: 6:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>






<html>
<head>
    <jsp:include page="components/header.jsp"/>
</head>
<body>
<jsp:include page="components/title.jsp"/>
<jsp:include page="components/menu.jsp"/>

<div class="container">
    <h2 class="text-center offset-1 text-info">Login</h2>
    <form method="post" action="LoginServlet">

        <div class="row justify-content-center mb-1">
            <label class="col-1" for="username">Username: </label>
            <div class="col-4">
                <input class="form-control " type="email" id="username" name="username"/>
            </div>
        </div>


        <div class="row justify-content-center mb-1">
            <label class="col-1" for="password">Password: </label>
            <div class="col-4">
                <input class="form-control" type="password" id="password" name="password"/>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-1 mt-3 offset-1 d-grid">
                <button class="btn btn-outline-primary" type="submit">Login</button>
            </div>

            <div class="col-1 mt-3 d-grid">
                <button class="btn btn-outline-secondary" type="reset">Clear</button>
            </div>

            <div class="col-1 mt-3 d-grid">
                <a class="btn btn-outline-info" href="index.jsp">Home</a>
            </div>
        </div>



    </form>
</div>
<% String code = request.getParameter("loginFail");
    if (code != null) {%>
<div class="alert alert-warning alert-dismissible">
    <p>"Incorrect Username or Password"</p>
</div>
<% } %>

<jsp:include page="components/footer.jsp"/>
</body>
</html>
