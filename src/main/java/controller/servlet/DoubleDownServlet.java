package controller.servlet;

import java.io.*;
import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DoubleDownServlet", value = "/DoubleDownServlet")
public class DoubleDownServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PlayGame game = (PlayGame) session.getAttribute("game");

        if (game != null) {
//            try {
                double currentBet = game.getBet();
                game.setBet(currentBet * 2); // Double the bet

                // deal one more card
                game.playerTurn();

                session.setAttribute("betAmount", game.getBet());
                session.setAttribute("game", game);
                response.sendRedirect("continue.jsp");

                //Check Bust
                if (game.playerTotal() > 21) {
                    int winner = game.determineWinner();
                    game.setIsPlayersTurn(false);
                    game.setIsDealerTurn(false);
                    session.setAttribute("winner", winner);
                }
        } else {
            // Handle case where game is null - redirect to start page or show error
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}

