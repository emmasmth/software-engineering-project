package controller.servlet;

import java.io.*;

import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StartServlet", value = "/StartServlet")
public class StartServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        PlayGame game = (PlayGame) session.getAttribute("game");

        if (game == null) {
            game = new PlayGame();
            session.setAttribute("game", game);
        } else {
            game.clearHands();
        }

        game.play();

        response.sendRedirect("continue.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}
