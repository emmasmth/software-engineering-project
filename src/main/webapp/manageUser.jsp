<%@ page import="model.entity.User" %>
<%@ page import="controller.Registration" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: oliverkochpaiz
  Date: 11/24/23
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Registration registration = new Registration();
  List<User> lstUsers = registration.listUsers(null); %>

<html>
<head>
  <jsp:include page="components/header.jsp"/>
</head>
<body>

<jsp:include page="components/title.jsp"/>
<jsp:include page="components/menu.jsp"/>

<div class="row justify-content-center d-flex">
  <div class="col-1 mt-3 offset-1 d-grid">
    <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#CreateNewUser">Create New User</button>
  </div>



  <div class="col-1 mt-3 d-grid">
    <a class="btn btn-success" type="button" href="index.jsp">Delete User</a>
  </div>
</div>

<div class="container mt-3">
  <table class="table">
    <thead class="table-dark">
      <tr>
        <th>Edit</th>
        <th>Delete</th>
        <th>ID</th>
        <th>Name</th>
        <th>Username</th>
        <th>Permission</th>
        <th>Wins</th>
        <th>Losses</th>
      </tr>
    </thead>

    <tbody>
      <% for(User u: lstUsers){ %>
      <tr>
        <td>
          <button class="btn btn-info" type="button" data-bs-toggle="modal" data-bs-target="#editUserModal_<%= u.getID() %>">
            <i class="bi bi-pencil-square"></i>
          </button>
        </td>
        <td>
          <a href="../user/edituser.jsp?id=<%= u.getID()%>&login=<%= u.getLogin()%>&perm=<%= u.getPermission()%>">Delete</a>
        </td>
        <td><%=u.getID()%></td>
        <td><%=u.getName()%></td>
        <td><%=u.getLogin()%></td>
        <td><%=u.getPermissionAsString()%></td>
        <td><%=u.getWins()%></td>
        <td><%=u.getLoses()%></td>
      </tr>

      <div class="modal" id="editUserModal_<%= u.getID() %>">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Edit User <%=u.getID()%></h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="EditUserServlet">

              <div class="modal-body">

                <div class="row mb-1">
                  <label class="col-md-2" for="editedID">ID: </label>
                  <div class="col-8">
                    <input class="form-control" type="text" id="editedID" name="editedID" value="<%= u.getID() %>" readonly/>
                  </div>
                </div>

                <div class="row mb-1">
                  <label class="col-md-2" for="editedName">Name: </label>
                  <div class="col-8">
                    <input class="form-control" type="text" id="editedName" name="editedName" value="<%= u.getName() %>"/>
                  </div>
                </div>


                <div class="row mb-1">
                  <label class="col-md-2" for="editedUsername">Email: </label>
                  <div class="col-8">
                    <input class="form-control" type="email" id="editedUsername" name="editedUsername" value="<%= u.getLogin()%>"/>
                  </div>
                </div>

                <div class="row mb-1">
                  <label class="col-md-2" for="editedPass">Password: </label>
                  <div class="col-8">
                    <input class="form-control" type="password" id="editedPass" name="editedPass"/>
                  </div>
                </div>

                <div class="row mb-1">
                  <label class="col-md-2" for="editedPermission">Permission: </label>
                  <div class="col-8">
                    <input class="form-control" type="text" id="editedPermission" name="editedPermission" value="<%= u.getPermission()%>"/>
                  </div>
                </div>

                <div class="row mb-1">
                  <label class="col-md-2" for="editedWins">Wins: </label>
                  <div class="col-8">
                    <input class="form-control" type="text" id="editedWins" name="editedWins" value="<%= u.getWins()%>"/>
                  </div>
                </div>

                <div class="row mb-1">
                  <label class="col-md-2" for="editedLosses">Losses: </label>
                  <div class="col-8">
                    <input class="form-control" type="text" id="editedLosses" name="editedLosses" value="<%= u.getLoses()%>"/>
                  </div>
                </div>


              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Save</button>
              </div>
            </form>
          </div>
        </div>
      </div>



    <%} %>
    </tbody>
  </table>
</div>


<div class="modal" id="CreateNewUser">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Create New User</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form method="post" action="CreateNewUserServlet">

        <div class="modal-body">

        <div class="row mb-1">
          <label class="col-md-2" for="name">Name: </label>
          <div class="col-8">
            <input class="form-control" type="text" id="name" name="name"/>
          </div>
        </div>


        <div class="row mb-1">
          <label class="col-md-2" for="username">Email: </label>
          <div class="col-8">
            <input class="form-control" type="email" id="username" name="username"/>
          </div>
        </div>

        <div class="row mb-1">
          <label class="col-md-2" for="pass">Password: </label>
          <div class="col-8">
            <input class="form-control" type="password" id="pass" name="password"/>
          </div>
        </div>

        <div class="row mb-1">
          <label class="col-md-2" for="permission">Permission: </label>
          <div class="col-8">
            <input class="form-control" type="text" id="permission" name="permission"/>
          </div>
        </div>

        <div class="row mb-1">
          <label class="col-md-2" for="wins">Wins: </label>
          <div class="col-8">
            <input class="form-control" type="text" id="wins" name="wins"/>
          </div>
        </div>

        <div class="row mb-1">
          <label class="col-md-2" for="losses">Losses: </label>
          <div class="col-8">
            <input class="form-control" type="text" id="losses" name="losses"/>
          </div>
        </div>


      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Create</button>
      </div>
      </form>
    </div>
  </div>
</div>









<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
