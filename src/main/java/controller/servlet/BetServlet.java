package controller.servlet;

import java.io.*;
import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "BetServlet", value = "/BetServlet")
public class BetServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PlayGame game = new PlayGame();
//        PlayGame game = (PlayGame) session.getAttribute("game");

        if (game != null) {
            try {
                int betAmount = Integer.parseInt(request.getParameter("betAmount"));
                // Validation logic can be added here (e.g., checking if the user has enough balance)

                game.setBet(betAmount);
                session.setAttribute("game", game);
                session.setAttribute("betAmount", betAmount); // Storing the bet amount in session
                response.sendRedirect("continue.jsp"); // Redirect to continue.jsp
            } catch (NumberFormatException e) {
                // Handle invalid bet amount (e.g., not a number)
                // Optionally redirect to an error page or back to the betting page with an error message
                response.sendRedirect("betting.jsp?error=InvalidBetAmount");
            }
        } else {
            // Redirect if no game is in session, or handle this scenario as per your application's flow
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}
