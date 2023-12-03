<%@ page import="model.entity.Ad" %>
<%@ page import="controller.AdService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: emmasmith
  Date: 11/10/23
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Ad</title>
    <jsp:include page="components/header.jsp"/>

    <style>
        .body
        {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        .box-container
        {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 80vh;
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
            margin-top: 6%;
        }

        @media screen and (max-width: 768px)
        {
            .white-box
            {
                margin-top: 50px;
            }
        }

        .button-container
        {
            text-align: center;
        }

        table
        {
            justify-content: center;
            width: 100%;
        }

        td
        {
            justify-content: center;
            padding: 8px;
            border: 1px solid #dddddd;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="button.css">
</head>
<body class="body">
    <jsp:include page="components/title.jsp"/>
    <jsp:include page="components/background.jsp"/>
    <jsp:include page="components/menu.jsp"/>

    <div class="box-container">
        <div class="white-box">
            <h2>Choose an Advertisement to Delete: </h2>
            <br>
            <form action="DeleteAdServlet" method="post">
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Filename</th>
                        <th>Delete</th>
                    </tr>
                    <tbody>
                    <%
                        List<Ad> lstAds = AdService.listAds(null);

                        for(Ad a : lstAds) {
                    %>
                    <tr>
                        <td><%=a.getID()%></td>
                        <td><%=a.getFilename()%></td>

                        <td>
                            <input  type="radio" id="idAdUploads" name="idAdUploads" value="<%=a.getID()%>">
                        </td>
                    </tr>

                    <%
                        }
                    %>
                    </tbody>
                </table>

                <br>
                <div class="button-container">
                    <button class="button-click" type="submit">Delete Selected Ad</button>
                </div>

            </form>
        </div>

        <div class="button-container">
            <button class="button-click" onclick="window.location.href = 'admin.jsp';">Back</button>
        </div>

    </div>

    <jsp:include page="components/footer.jsp"/>
</body>
</html>
