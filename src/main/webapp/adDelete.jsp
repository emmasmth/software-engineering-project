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
    <title>Title</title>
</head>
<body>
    <h1>Delete!</h1>


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
                <td><input class="form-control" type="checkbox" name="idAdUploads" value="<%=a.getID()%>"> </td>
            </tr>

            <%
                }
            %>
            </tbody>
        </table>

        <br>
        <input type="submit" value="Delete Selected Ad">
    </form>

<p>bye</p>


</body>
</html>
