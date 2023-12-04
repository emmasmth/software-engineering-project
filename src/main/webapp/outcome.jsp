<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 12/3/23
  Time: 12:06 PM
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
        <div class="row text-center mt-3">
            <%//print outcome and payout%>
            <h2><%= session.getAttribute("outcomeMessage") %></h2>
            <p>Payout: $ <%= session.getAttribute("payout") %></p>

            <!-- New Game Button (resets game and redirects to beginning)-->
            <form method="post" action="NewGameServlet">
                <button type="submit" class="btn btn-success">New Game</button>
            </form>

            <!-- Leaderboard Button-->
            <form method="post" action="LeaderboardServlet">
                <button type="submit" class="btn btn-warning">Leaderboard</button>
            </form>

            <jsp:include page="components/footer.jsp"/>
        </div>
    </div>
</body>
</html>
