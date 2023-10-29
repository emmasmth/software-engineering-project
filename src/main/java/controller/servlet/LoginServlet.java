package controller.servlet;

import java.io.*;

import controller.Registration;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.entity.User;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Registration register = new Registration();

        User logged = register.loginUser(username, password);
        if(logged!=null){
            HttpSession session = request.getSession();
            logged.setPassword("");
            session.setAttribute("User", logged);
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("login.jsp?loginFail=1");
        }


    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}