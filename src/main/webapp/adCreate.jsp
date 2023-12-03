<%--
  Created by IntelliJ IDEA.
  User: emmasmith
  Date: 11/10/23
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.entity.Ad" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="components/header.jsp"/>
    <title>Ad Upload</title>

    <style>
        .box-container
        {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }
    </style>

    <link rel="stylesheet" type="text/css" href="button.css">
</head>
<body>
    <jsp:include page="components/title.jsp"/>
    <jsp:include page="components/background.jsp"/>
    <jsp:include page="components/menu.jsp"/>
    <!-- https://blog.filestack.com/api/everything-need-know-bootstrap-file-upload/ -->
    <div class="box-container">
        <h1>Create!</h1>
        <h1></h1>
        <!-- https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-File-Upload-Servlet-Ajax-Example -->
        <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" class="form-control" id="file" name="file"/>
            <br>
            <p>Enter Filename:</p>
            <input type="text" class="form-control" id="filename" name="filename"/>
            <input type="submit" value="Upload"/>
        </form>

        <div class="button-container">
            <button class="button-click" onclick="window.location.href = 'admin.jsp';">Back</button>
        </div>
    </div>

    <jsp:include page="components/footer.jsp"/>
</body>
</html>
