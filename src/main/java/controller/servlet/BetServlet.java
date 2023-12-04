package controller.servlet;

import java.io.*;
import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.entity.User;
import controller.Registration;
import model.dao.UserDAO;


@WebServlet(name = "BetServlet", value = "/BetServlet")
public class BetServlet extends HttpServlet {
    public Registration registration = new Registration();
    public static UserDAO dao = new UserDAO();
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PlayGame game = new PlayGame();
//        PlayGame game = (PlayGame) session.getAttribute("game");

//        if (game != null) {
            try {
                double betAmount = Double.parseDouble(request.getParameter("betAmount"));
                // Validation logic can be added here (e.g., checking if the user has enough balance)

                game.setBet(betAmount);
                session.setAttribute("game", game);
                session.setAttribute("betAmount", betAmount); // Storing the bet amount in session

                User user = (User) session.getAttribute("User");
                user.subFromBank(betAmount);
                registration.updateUser(user);

                response.sendRedirect("StartServlet");

            } catch (NumberFormatException e) {
                // Handle invalid bet amount (e.g., not a number - redirect back to the betting page with an error message
                response.sendRedirect("betting.jsp?error=InvalidBetAmount");
            }
//        } else {
//            // Redirect if no game is in session, or handle this scenario as per your application's flow
//            response.sendRedirect("index.jsp");
//        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}
