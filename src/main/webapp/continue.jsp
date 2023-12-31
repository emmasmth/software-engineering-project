<%@ page import="model.entity.User" %>
<%@ page import="controller.Card" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.PlayGame" %><%--

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
    <style>
        @keyframes drawCard {
            0% {
                transform: translateY(-50px) rotate(-5deg) scale(0.9);
                opacity: 0;
            }
            100% {
                transform: translateY(0) rotate(0) scale(1);
                opacity: 1;
            }
        }

        .blackjack-card.drawing {
            animation: drawCard 0.5s ease-in-out;
        }
    </style>

</head>
<body>
<jsp:include page="components/title.jsp"/>
<jsp:include page="components/menu.jsp"/>

<div class="container">
    <div class="row text-center mt-3">
        <%
            User user = (User) session.getAttribute("User");
            PlayGame game = (PlayGame) session.getAttribute("game");
            Integer winner = (Integer) session.getAttribute("winner");


            //game not started - only show play button, leads to bet page
            if (game == null){
                %>
                <p>No game started. Click "Play" to start your game session.</p>
                <form action="NewGameServlet" method="post">
                    <button type="submit" class="btn btn-success">Play</button>
                </form>
                <form method="get" action="LeaderboardServlet">
                    <button type="submit" class="btn btn-warning">Leaderboard</button>
                </form>
                <%
            //game started, continue with play
            } else {
                    //deal cards
                    ArrayList<Card> dealerHand = game.getDealerHand();
                    ArrayList<Card> playerHand = game.getPlayerHand();

                    //show bet amount
                    Double betAmount = (Double) session.getAttribute("betAmount");
                    if (betAmount != null) {
                        out.println("<p>Your bet amount: " + betAmount + "</p>");
                    } else {
                        out.println("<p>No bet placed.</p>");
                    }
                    out.println(user.getBank());
                %>

                <div>
                    <% //show dealer hand
                        if (game.getIsPlayersTurn()) { %>
                            <h3>Dealer's Hand: <%= game.dealerFirstCardValue() %></h3>
                    <% } else {%>
                            <h3>Dealer's Hand: <%= game.dealerTotal() %></h3>
                    <% }
                        session.setAttribute("dealerTotal", game.dealerTotal());
                     int cardIndex = 0;
                     for (Card card : dealerHand) {
                        String imageFileName;
                        if (cardIndex == 1 && game.getIsPlayersTurn()) {
                            // Display the back of the card if it's the second card and it's still the player's turn
                            imageFileName = "card_back.png";

                        } else {
                            imageFileName = card.getNumber() + "_of_" + card.getSuit() + ".png";
                        }
                        cardIndex++;
                    %>
                    <img src="images/<%= imageFileName %>" alt="<%= card.getNumber() %>_of_<%= card.getSuit() %> "width="75" height="75">
                    <% } %>
                </div>


                <div>
                    <% //show player's hand%>
                    <h3>Player's Hand: <%= game.playerTotal() %></h3>
                    <% session.setAttribute("playerTotal", game.playerTotal());
                        for (Card card : playerHand) { %>
                    <%
                        String imageFileName = card.getNumber() + "_of_" + card.getSuit()+ ".png";
                    %>

                    <img src="images/<%= imageFileName %>" alt="<%= card.getNumber() %>_of_<%= card.getSuit() %> " class="blackjack-card drawing" width="75" height="75">
                    <% } %>
                </div>
    </div>
</div>

<!-- Game Controls -->
<div class="row justify-content-center mt-3">
    <!-- Hit Button -->
    <div class="col-1 d-grid">
        <a href="HitServlet" class="btn btn-success">Hit</a>
    </div>
    <!-- Stand Button -->
    <div class="col-1 d-grid">
        <form method="post" action="StandServlet">
            <button type="submit" class="btn btn-danger">Stand</button>
        </form>
    </div>
    <%-- Double Down Button--%> <%
    if (game != null && game.getPlayerHand().size() > 0) {
    if (game.getPlayerHand().size()==2){%>
    <div class="col-1 d-grid">
        <a href="DoubleDownServlet" class="btn btn-warning">Double</a>
    </div>
        <% } }%>
    <% if(winner!=null && winner!=0){
        session.setAttribute("dealerHand", game.getDealerHand());
        session.setAttribute("playerHand", game.getPlayerHand());
        String message;
        switch(winner) {
            case 1: message = "It's a tie!"; break;
            case 2: message = "Player wins!"; break;
            case 3: message = "Dealer wins!"; break;
            default: message = "Unexpected game outcome."; break;
        }
//        out.println("<h3>" + message + "</h3>");
        session.setAttribute("outcomeMessage", message);
        game.calcPayOut();
        double payout = game.getPayout();
        session.setAttribute("payout", payout);
        response.sendRedirect("outcome.jsp");
        return;
    }
    %>
    </div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<%}%>


</body>
</html>