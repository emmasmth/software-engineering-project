package controller.servlet;

import java.io.*;
import java.security.Permission;

import controller.Registration;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.entity.User;

@WebServlet(name = "EditUserServlet", value = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    public Registration registration = new Registration();

    public void setRegistration(Registration register){
        this.registration = register;
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String editedID = request.getParameter("editedID");
        String editedName = request.getParameter("editedName");
        String editedUsername = request.getParameter("editedUsername");
        String editedPass = request.getParameter("editedPass");
        String editedPermission = request.getParameter("editedPermission");
        String editedWins = request.getParameter("editedWins");
        String editedLosses = request.getParameter("editedLosses");
        String editedBalance = request.getParameter("editedBalance");

        User editedUser = new User();
        editedUser.setID(Integer.parseInt(editedID));
        editedUser.setName(editedName);
        editedUser.setLogin(editedUsername);
        editedUser.setPassword(editedPass);
        editedUser.setPermission(Integer.parseInt(editedPermission));
        editedUser.setWins(Integer.parseInt(editedWins));
        editedUser.setLoses(Integer.parseInt(editedLosses));
        editedUser.setBank(Double.parseDouble(editedBalance));

        registration.editUser(editedUser);
        response.sendRedirect("manageUser.jsp");

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}