package controller.servlet;

import java.io.*;

import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HitServlet", value = "/HitServlet")
public class HitServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PlayGame game = (PlayGame) session.getAttribute("game");
        if (game != null) {
            if (game.playerTotal() < 21) {
                game.playerTurn();
            }
            session.setAttribute("game", game);
        }
        response.sendRedirect("continue.jsp");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}