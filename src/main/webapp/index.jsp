<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Instructions</title>
    <jsp:include page="components/header.jsp"/>
    <style>

        .p_header_font
        {
            font-family: "American Typewriter" , sans-serif;
            font-size: xx-large;
        }

        .p_font_large
        {
            font-family: "American Typewriter", sans-serif;
            font-size: large;
        }

        .p_font_medium
        {
            font-family: "American Typewriter", sans-serif;
            font-size: medium;
        }

        .p_font_small
        {
            font-family: "American Typewriter", sans-serif;
            font-size: small;
        }

        .container
        {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .white-box
        {
            -ms-overflow-style: scrollbar;
            scrollbar-width: thin;
            overflow-y: scroll;
            scroll-behavior: auto;
            background-color: white;
            border: 5px solid black;
            padding: 5%;
            text-align: center;
            width: 50%;
            height: 50%;
        }

    </style>
</head>
<body>
    <jsp:include page="components/background.jsp"/>
    <div class = "container">
        <div class = "white-box">
            <div class = "p_header_font">
                <p>How to Play:</p>
            </div>

            <div class = "p_font_large">
                <!-- https://www.blackjackapprenticeship.com/how-to-play-blackjack/ -->
                <p>Objective:</p>
            </div>
            <div class="p_font_medium">
                <p>FIX ME add objectives</p>
            </div>
            <div class="p_font_large">
                <p>Gameplay:</p>
            </div>
            <div class="p_font_medium">
                <p>Each player will be dealt a card that is face up. The dealer will get a card face down.
                    Then, each player and the dealer will get another card that is face up.</p>
                <p>Going left to right, each player will play their hand by choosing to do one of the following:</p>
            </div>
            <div class="p_font_small">
                <p>Stand: </p>
                <p>Hit: </p>
                <p>Double Down: </p>
                <p>Split: </p>
                <p>Surrender: </p>
                <p>Each player will be dealt a card that is face up. The dealer will get a card face down.
                    Then, each player and the dealer will get another card that is face up.Each player will be dealt a card that is face up. The dealer will get a card face down.
                    Then, each player and the dealer will get another card that is face up.Each player will be dealt a card that is face up. The dealer will get a card face down.
                    Then, each player and the dealer will get another card that is face up.Each player will be dealt a card that is face up. The dealer will get a card face down.
                    Then, each player and the dealer will get another card that is face up.Each player will be dealt a card that is face up. The dealer will get a card face down.
                    Then, each player and the dealer will get another card that is face up.</p>
            </div>
        </div>
    </div>
</body>
</html>