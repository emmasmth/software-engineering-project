<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Instructions</title>
    <jsp:include page="components/header.jsp"/>
    <style>

        .p_header_font
        {
            font-family: "American Typewriter" , sans-serif;
            font-size: x-large;
        }

        .p_font
        {
            font-family: "American Typewriter", sans-serif;
            font-size: medium;
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
            background-color: white;
            border: 1px solid black;
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

            <div class = "p_font">
                <p>instructions here blah blah blah blah blah </p>
            </div>
        </div>
    </div>
</body>
</html>