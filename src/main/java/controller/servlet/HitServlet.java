package controller.servlet;

import java.io.*;

import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HitServlet", value = "/HitServlet")
public class HitServlet extends HttpServlet {
    public PlayGame game;

    public void setGame(PlayGame game){
        this.game = game;
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        game = (PlayGame) session.getAttribute("game");
        if (game != null) {
            if (game.playerTotal() < 21) {
                game.playerTurn();
            }
            //Check Bust
            if (game.playerTotal() > 21) {
                int winner = game.determineWinner();
                session.setAttribute("winner", winner);
            }
            //Check naturals
            if (game.playerTotal() == 21 || game.dealerTotal() == 21) {
                int winner = game.determineWinner();
                session.setAttribute("winner", winner);
            }






            session.setAttribute("game", game);
        }
        response.sendRedirect("continue.jsp");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}