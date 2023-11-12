package controller.servlet;

import java.io.*;
import controller.PlayGame;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StandServlet", value = "/StandServlet")
public class StandServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        PlayGame game = (PlayGame) session.getAttribute("game");

        if (game != null) {
            // Indicate player's turn is over
            game.setIsPlayersTurn(false);

            // dealer's turn
            while (game.dealerTotal()<17) {
                game.dealerTurn();
            }

            //get the winner
            int winner = game.determineWinner();
            session.setAttribute("winner", winner);

            session.setAttribute("game", game);
            response.sendRedirect("continue.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }
}
