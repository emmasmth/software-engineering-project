<%--
  Created by IntelliJ IDEA.
  User: emmasmith
  Date: 11/12/23
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.List" %>
<%@ page import ="model.entity.Ad" %>
<%@ page import ="model.dao.AdDAO" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.OutputStream" %>

<!-- https://stackoverflow.com/questions/1076972/snippet-to-create-a-file-from-the-contents-of-a-blob-in-java -->

<html>
<head>
    <title>Temp Display</title>

    <style>
        .img-container
        {
            max-width: 300px;
            max-height: 200px;
        }
    </style>
</head>
<body>
<%
    AdDAO adDAO = new AdDAO();
    List<Ad> ads = adDAO.list("idAdUploads");
%>

<p> <%= ads.size() %></p>

<%
    //for(Ad ad : ads) {
    {
%>

<div class="img-container">


    <%
        Ad ad = ads.get(0); // THIS JUST GETS THE FIRST ONE IN THE LIST NEEDS TO BE CHANGED!!!
        Blob fileBlob = ad.getFilecontents();

        String contentType = "image";

        response.setContentType(contentType);

        try (InputStream inputStream = fileBlob.getBinaryStream();
             OutputStream outputStream = response.getOutputStream()) {
            byte[] buff = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

</div>

<%
    }
%>


</body>
</html>