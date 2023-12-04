<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 12/3/23
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.entity.User" %>
<%@ page import="controller.Card" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.PlayGame" %>
<%@ page import="controller.Registration"%>
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
            <%
                Registration registration = new Registration();
                Integer winner = (Integer) session.getAttribute("winner");
                User user = (User) session.getAttribute("User");
                switch (winner){
                    case 2: user.incWins();
                    case 3: user.incLoses();
                }
                user.addToBank((Double) session.getAttribute("payout"));
                registration.updateUser(user);
            %>
            <%//print outcome and payout%>
            <h1><%= session.getAttribute("outcomeMessage") %></h1>
            <h2>Payout: $ <%= session.getAttribute("payout") %></h2>
<%--            <% User user = (User) session.getAttribute("User");%>--%>
            <h2>Bank: <%=user.getBank() %></h2>

            <!-- New Game Button (resets game and redirects to beginning)-->
            <form method="post" action="NewGameServlet">
                <button type="submit" class="btn btn-success">New Game</button>
            </form>

            <!-- Leaderboard Button-->
            <form method="get" action="LeaderboardServlet">
                <button type="submit" class="btn btn-warning">Leaderboard</button>
            </form>

            <div>
            <%
            String imageFileName;
            ArrayList<Card> dealerHand = (ArrayList<Card>) session.getAttribute("dealerHand");
            ArrayList<Card> playerHand = (ArrayList<Card>) session.getAttribute("playerHand");%>

            <h4>Dealers's Hand: <%= session.getAttribute("dealerTotal") %></h4>
            <%for (Card card: dealerHand) {
                imageFileName = card.getNumber() + "_of_" + card.getSuit() + ".png";%>
                <img src="images/<%= imageFileName %>" alt="<%= card.getNumber() %>_of_<%= card.getSuit() %> "width="50" height="50">
           <% }%>

            <h4>Player's Hand: <%= session.getAttribute("playerTotal") %></h4>
            <%for (Card card: playerHand) {
                imageFileName = card.getNumber() + "_of_" + card.getSuit() + ".png";%>
                <img src="images/<%= imageFileName %>" alt="<%= card.getNumber() %>_of_<%= card.getSuit() %> "width="50" height="50">
            <% }%>
            </div>

            <jsp:include page="components/footer.jsp"/>
        </div>
    </div>
</body>
</html>
