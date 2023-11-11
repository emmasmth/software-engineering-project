<%--
  Created by IntelliJ IDEA.
  User: emmasmith
  Date: 11/9/23
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <jsp:include page="components/header.jsp"/>

    <style>
        .box-container
        {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }


    </style>
</head>
<body>
    <jsp:include page="components/title.jsp"/>
    <jsp:include page="components/background.jsp"/>
    <jsp:include page="components/menu.jsp"/>
    <jsp:include page="components/adminNav.jsp"/>
    <div class="box-container">
        <p>
            Hello, this is where some user data and game stats stuff will go :)
        </p>

    </div>

    <jsp:include page="components/footer.jsp"/>
</body>
</html>
