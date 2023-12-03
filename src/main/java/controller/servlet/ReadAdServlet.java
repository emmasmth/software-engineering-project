package controller.servlet;

import controller.AdService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.IIOException;
import model.entity.Ad;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReadAdServlet", value = "/ReadAdServlet")
public class ReadAdServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ad> updatedAds = AdService.listAds(null);
        request.setAttribute("adsList", updatedAds);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/adRead.jsp");
        dispatcher.forward(request,response);
    }

}
