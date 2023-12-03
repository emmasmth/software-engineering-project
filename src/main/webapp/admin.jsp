<%--
  Created by IntelliJ IDEA.
  User: emmasmith
  Date: 11/9/23
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="controller.Passwords" %>
<%@ page import="model.entity.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin Page</title>
    <jsp:include page="components/header.jsp"/>

    <style>

        .white-box
        {
            background-color: white;
            border: 5px solid black;
            padding: 5%;
            text-align: center;
            width: 50%;
            height: 35%;
            margin-top: 3%;
        }

        .box-container
        {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }

        @media screen and (max-width: 1800px)
        {
            .white-box
            {
                -ms-overflow-style: scrollbar;
                scrollbar-width: thin;
                overflow-y: scroll;
                scroll-behavior: auto;
                margin-top: 10px;
            }
        }

    </style>
    <link rel="stylesheet" type="text/css" href="button.css">
</head>
<body>
    <jsp:include page="components/title.jsp"/>
    <jsp:include page="components/background.jsp"/>
    <jsp:include page="components/menu.jsp"/>

    <% User logged = (User) session.getAttribute("User"); %>
    <% if (logged != null && logged.getPermission() == 2)
    { %>
        <div class="box-container">
            <div class="white-box">
                <h2>Edit Users</h2>
                <div class="button-container">
                    <button class="button-click" onclick="window.location.href = 'manageUser.jsp';">Manage Users</button>
                </div>
            </div>

            <div class="white-box">
                <h2>Edit Advertisements</h2>
                <div class="button-container">
                    <!-- https://www.w3schools.com/css/css3_buttons.asp -->
                    <button class="button-click" onclick="window.location.href = 'adCreate.jsp';">Create</button>
                    <button class="button-click" onclick="window.location.href = 'adRead.jsp';">Read</button>
                    <button class="button-click" onclick="window.location.href = 'adUpdate.jsp';">Update</button>
                    <button class="button-click" onclick="window.location.href = 'adDelete.jsp';">Delete</button>
                </div>
            </div>
            <div class="button-container">
                <button class="button-click" onclick="window.location.href = 'index.jsp';">Back</button>
            </div>
        </div>
    <% } else { %>
    <div class="box-container">
        <h1>You are not an admin.</h1>
        <div class="button-container">
            <button class="button-click" onclick="window.location.href = 'index.jsp';">Back</button>
        </div>
    </div>

    <% } %>

    <jsp:include page="components/footer.jsp"/>
</body>
</html>
