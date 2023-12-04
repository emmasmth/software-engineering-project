<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 12/3/23
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.User" %>
<%@ page import="controller.Registration" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <jsp:include page="components/header.jsp"/>
</head>
<body>
    <jsp:include page="components/title.jsp"/>
    <jsp:include page="components/menu.jsp"/>
    <h2>Leaderboard</h2>
    <div class="container mt-3">
        <table class="table">
            <% User logged = (User) session.getAttribute("User");%>
            <tr>
                <th>Rank</th>
                <th>Name</th>
                <th>Wins</th>
                <th>Losses</th>
            </tr>
                <%
                List<User> users = (List<User>) request.getAttribute("users");
                int rank = 1;
                for (User user : users) {
                %>

            <tr>
                <td><%= rank++ %></td>
                <td><%=user.getName()%></td>
                <td><%=user.getWins()%></td>
                <td><%=user.getLoses()%></td>
            </tr>
            <%} %>

        </table>
    </div>
    <jsp:include page="components/footer.jsp"/>
</body>
</html>
