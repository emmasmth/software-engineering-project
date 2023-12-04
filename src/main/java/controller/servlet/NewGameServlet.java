package controller.servlet;

import controller.PlayGame;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "NewGameServlet", value = "/NewGameServlet")
public class NewGameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Clear the game-related attributes


        session.removeAttribute("game");
        session.removeAttribute("betAmount");
        session.removeAttribute("winner");
        session.removeAttribute("payout");

        PlayGame game = new PlayGame();
        session.setAttribute("game",game);

        // Redirect to the initial page to start a new game
        response.sendRedirect("betting.jsp");
    }
}
