package controller.servlet;

import java.io.*;

import controller.Registration;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    public Registration registration = new Registration();

    public void setRegistration(Registration register){
        this.registration = register;
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        registration.deleteUser(id);
        response.sendRedirect("manageUser.jsp");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }


}