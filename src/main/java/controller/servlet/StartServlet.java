package controller.servlet;

import java.io.*;

import controller.Blackjack;
import controller.Card;
import controller.Game;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StartServlet", value = "/StartServlet")
public class StartServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        // Create a new game and deck
        Game game = new Game();
        game.play();
        // Deal initial cards and set the game in the session
        session.setAttribute("game", game);

        response.sendRedirect("continue.jsp");
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}

