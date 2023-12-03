package controller.servlet;

import controller.AdService;
import jakarta.servlet.Registration;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Ad;
import model.entity.User;

import java.io.IOException;

@WebServlet(name = "DeleteAdServlet", value="/DeleteAdServlet")
public class DeleteAdServlet extends HttpServlet
{
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        int id = Integer.parseInt(request.getParameter("idAdUploads"));

        Ad ad = (Ad) request.getSession().getAttribute("Ad");
        User logged = (User) request.getSession().getAttribute("User");
        if(logged != null && logged.getPermission() == User.ADMIN_PERMISSION)
        {
            AdService.deleteAd(id);
            response.sendRedirect("admin.jsp");
        }
        else
        {
            response.sendRedirect("index.jsp");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        processRequest(request, response);
    }
}
