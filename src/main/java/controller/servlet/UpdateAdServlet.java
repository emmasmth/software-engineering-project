package controller.servlet;

import controller.AdService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.AdDAO;
import model.entity.Ad;
import model.entity.User;

import java.io.IOException;
import java.nio.file.Path;

@WebServlet(name = "UpdateAdServlet", value = "/UpdateAdServlet")
@MultipartConfig
public class UpdateAdServlet extends HttpServlet
{
    public void processRequest(HttpServletRequest request, HttpServletResponse repsonse) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("idAdUploads"));
        String newname = request.getParameter("filename");

        User logged = (User) request.getSession().getAttribute("User");
        if(logged != null && logged.getPermission() == User.ADMIN_PERMISSION)
        {
            Ad ad = AdService.getAd(id);
            ad.setFilename(newname);

            String sTarg = getServletContext().getRealPath("/adimages/");

            AdService.editAd(ad, sTarg);

            repsonse.sendRedirect("adRead.jsp");
        }
        else
        {
            repsonse.sendRedirect("index.jsp");
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }
}
