<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Instructions</title>
    <jsp:include page="components/header.jsp"/>
    <style>

        .body
        {
            height: 100%;
            margin: 0;
            padding: 0;
        }

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
            flex-direction: column;
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

        .button-click
        {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            font-size: 16px;
            font-family: "American Typewriter", sans-serif;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            color: black;
            background-color: darkgray;
            border: none;
            border-radius: 15px;
            box-shadow: 0 9px #999;
        }

        .button-click:hover
        {
            background-color: #3e8e41;
        }

        .button-click:active
        {
            background-color: #3e8e41;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }

    </style>
</head>
<body class="body">
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
                <p>Stand: FIX ME</p>
                <p>Hit: FIX ME</p>
                <p>Double Down: FIX ME</p>
                <p>Split: FIX ME</p>
                <p>Surrender: FIX ME</p>
                <p>
                    Each player will be dealt a card that is face up. The dealer will get a card face down.
                    FIX ME
                </p>
            </div>
        </div>
        <!-- https://www.w3schools.com/css/css3_buttons.asp -->
        <button class="button-click" onclick="window.location.href = 'continue.jsp';">Continue</button>
    </div>
    <jsp:include page="components/footer.jsp"/>


</body>
</html>