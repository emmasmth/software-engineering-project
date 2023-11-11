<%--
  Created by IntelliJ IDEA.
  User: emmasmith
  Date: 11/9/23
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>

<!-- https://www.w3schools.com/bootstrap/bootstrap_carousel.asp-->

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="components/header.jsp"/>
    <title>Advertisements</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        .carousel-inner img
        {
            max-width: 50vw;
            max-height: 75vh;
            margin: auto;
            display: block;
        }

        .carousel-inner .item
        {
            transition-duration: 0.3s;
        }

        .button-container
        {
            text-align: center;
            visibility: hidden;
            animation: fadeIn 2s forwards 10s;
        }

    </style>

    <link rel="stylesheet" type="text/css" href="button.css">
</head>
<body>

    <jsp:include page="components/title.jsp"/>
    <jsp:include page="components/background.jsp"/>
    <jsp:include page="components/menu.jsp"/>

    <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="adimages/fakead1.PNG" alt="fake image 1">
            </div>

            <div class="item">
                <img src="adimages/fakead2.png" alt="fake image 2">
            </div>

            <div class="item">
                <img src="adimages/fakead3.PNG" alt="fake image 3">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div class="button-container">
        <!-- https://www.w3schools.com/css/css3_buttons.asp -->
        <!-- https://www.w3schools.com/css/css3_animations.asp -->
        <!-- https://stackoverflow.com/questions/21993661/css-auto-hide-elements-after-5-seconds -->

        <button class="button-click" onclick="window.location.href = 'continue.jsp';">Continue</button>
    </div>

    <jsp:include page="components/footer.jsp"/>

</body>
</html>
