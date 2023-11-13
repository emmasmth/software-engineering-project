package controller.servlet;

import java.io.*;

import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StartServlet", value = "/StartServlet")
public class StartServlet extends HttpServlet {
    public PlayGame game;

    public void setGame(PlayGame game){
        this.game = game;
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        game = (PlayGame) session.getAttribute("game");

        if (game == null) {
            game = new PlayGame();
            session.setAttribute("game", game);
        } else {
            game.clearHands();
        }

        game.setIsPlayersTurn(true);
        game.play();

        //Check naturals
        if (game.playerTotal() == 21 || game.dealerTotal() == 21) {
            int winner = game.determineWinner();
            game.setIsDealerTurn(false);
            game.setIsPlayersTurn(false);

            session.setAttribute("winner", winner);
        }

        response.sendRedirect("continue.jsp");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}
