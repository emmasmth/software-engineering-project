<%--
  Created by IntelliJ IDEA.
  User: emmasmith
  Date: 11/10/23
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <form method="post" action="fileuploadservlet" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="submit" value="Upload">
        </form>
    </div>

    <jsp:include page="components/footer.jsp"/>
</body>
</html>
