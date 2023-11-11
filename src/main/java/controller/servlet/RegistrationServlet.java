package controller.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.constraints.Null;
import model.entity.User;
import controller.Registration;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    public Registration registration = new Registration();

    public void setRegistration(Registration register){
        this.registration = register;
    }


    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setLogin(username);
        user.setPassword(password);

        User userRegistered = registration.registerUser(user);

        if(userRegistered != null){
            response.sendRedirect("login.jsp");
        }
        else{
            response.sendRedirect("registration.jsp?error=1");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}