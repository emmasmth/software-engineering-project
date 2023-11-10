<%@ page import="controller.Blackjack" %>
<%@ page import="controller.Card" %>
<%@ page import="controller.Game" %>
<%@ page import="java.util.ArrayList" %><%--

  Created by IntelliJ IDEA.
  User: emmasmith
  Date: 10/25/23
  Time: 11:00 PM
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
        <%
            Game game = (Game) session.getAttribute("game");
            if (game != null) {
                ArrayList<Card> dealerHand = game.getDealerHand();
                ArrayList<Card> playerHand = game.getPlayerHand();
        %>

        <div>
            <h3>Dealer's Hand: <%= game.dealerTotal() %></h3>
            <% for (Card card : dealerHand) { %>
            <%
                String imageFileName = card.getNumber() + "_of_" + card.getSuit() + ".png";
            %>

            <img src="images/<%= imageFileName %>" alt="<%= card.getNumber() %>_of_<%= card.getSuit() %> " width="50" height="50">
            <% } %>
        </div>

        <div>
            <h3>Player's Hand: <%= game.playerTotal() %></h3>
            <% for (Card card : playerHand) { %>
            <%
                String imageFileName = card.getNumber() + "_of_" + card.getSuit()+ ".png";
            %>

            <img src="images/<%= imageFileName %>" alt="<%= card.getNumber() %>_of_<%= card.getSuit() %> " width="50" height="50">
            <% } %>
        </div>

        <%
        } else {
        %>
        <p>No card drawn yet. Click "Start" to draw a card.</p>
        <%
            }
        %>

    </div>
</div>

    <div class="row justify-content-center">
        <form method="post" action="StartServlet">
            <div class="col-1 d-grid">
                <button class="btn btn-outline-primary" type="submit">Start</button>
            </div>
        </form>
        <div class="col-1 d-grid">
            <a href="HitServlet" class="btn btn-outline-primary">Hit</a>
        </div>

        <div class="col-1 d-grid">
            <button class="btn btn-outline-primary" type="button">Stand</button>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>