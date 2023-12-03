package controller.servlet;

import java.io.*;

import controller.Registration;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.entity.User;

@WebServlet(name = "CreateNewUserServlet", value = "/CreateNewUserServlet")
public class CreateNewUserServlet extends HttpServlet {

    public Registration registration = new Registration();

    public void setRegistration(Registration register){
        this.registration = register;
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");
        String wins = request.getParameter("wins");
        String losses = request.getParameter("losses");
        int permissionInt = Integer.parseInt(permission);
        int winsInt = Integer.parseInt(wins);
        int lossesInt = Integer.parseInt(losses);


        User user = new User();
        user.setName(name);
        user.setLogin(username);
        user.setPassword(password);
        user.setPermission(permissionInt);
        user.setWins(winsInt);
        user.setLoses(lossesInt);

        User userRegistered = registration.registerUser(user);

        if(userRegistered != null){
            response.sendRedirect("manageUser.jsp");
        }
        else{
            response.sendRedirect("manageUser.jsp?error=1");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}