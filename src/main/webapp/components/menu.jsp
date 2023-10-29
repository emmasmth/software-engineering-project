<%@ page import="model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: oliverkochpaiz
  Date: 10/26/23
  Time: 3:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="index.jsp">Home</a>
            </li>
        </ul>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item dropdown">
                <% User logged = (User) session.getAttribute("User"); %>
                <% if (logged != null) { %>
                <a class="nav-link dropdown-toggle" type="button" data-bs-toggle="dropdown">
                    <%= "Account: " + logged.getName() %>
                </a>
                <% } else { %>
                <a class="nav-link dropdown-toggle" type="button" data-bs-toggle="dropdown">Account</a>
                <% } %><ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="login.jsp">Login</a></li>
                    <li><a class="dropdown-item" href="registration.jsp">Register</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="LogoutServlet">Logout</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
