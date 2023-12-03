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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(name = "DeleteAdServlet", value="/DeleteAdServlet")
public class DeleteAdServlet extends HttpServlet
{
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        int id = Integer.parseInt(request.getParameter("idAdUploads"));

        User logged = (User) request.getSession().getAttribute("User");
        if(logged != null && logged.getPermission() == User.ADMIN_PERMISSION)
        {
            Ad ad = AdService.getAd(id);
            AdService.deleteAd(id);
            String sTarg = getServletContext().getRealPath("/adimages/");
            Path pTarg = Path.of(sTarg, ad.getFilename());
            Files.deleteIfExists(pTarg);

            response.sendRedirect("adRead.jsp");
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
