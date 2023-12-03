package controller.servlet;

import java.io.*;
import java.security.Permission;

import controller.Registration;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.entity.User;

@WebServlet(name = "EditUserServlet", value = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String editedID = request.getParameter("editedID");
        String editedName = request.getParameter("editedName");
        String editedUsername = request.getParameter("editedUsername");
        String editedPass = request.getParameter("editedPass");
        String editedPermission = request.getParameter("editedPermission");
        String editedWins = request.getParameter("editedWins");
        String editedLosses = request.getParameter("editedLosses");

        User editedUser = new User();
        editedUser.setID(Integer.parseInt(editedID));
        editedUser.setName(editedName);
        editedUser.setLogin(editedUsername);
        editedUser.setPassword(editedPass);
        editedUser.setPermission(Integer.parseInt(editedPermission));
        editedUser.setWins(Integer.parseInt(editedWins));
        editedUser.setLoses(Integer.parseInt(editedLosses));


        Registration registration = new Registration();
        registration.editUser(editedUser);
        response.sendRedirect("manageUser.jsp");

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}