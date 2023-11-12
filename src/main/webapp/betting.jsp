<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 11/11/23
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="controller.PlayGame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="components/header.jsp"/>
    <style>
        /* Add any specific styles for your betting page here */
    </style>
</head>
<body>
<jsp:include page="components/title.jsp"/>
<jsp:include page="components/menu.jsp"/>

<div class="container">
    <div class="row text-center mt-3">
        <h2>Place Your Bet</h2>
        <form method="post" action="BetServlet">
            <div class="form-group">
                <label for="betAmount">Bet Amount:</label>
                <input type="number" class="form-control" id="betAmount" name="betAmount" placeholder="Enter bet amount" min="1" required>
            </div>
            <button type="submit" class="btn btn-primary mt-2">Submit Bet</button>
        </form>
    </div>
</div>

<jsp:include page="components/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

