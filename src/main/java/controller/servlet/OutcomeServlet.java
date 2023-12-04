package controller.servlet;
import java.io.*;
import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.entity.User;
import controller.Registration;


@WebServlet(name = "OutcomeServlet", value = "/OutcomeServlet")
public class OutcomeServlet extends HttpServlet{
    public Registration registration = new Registration();
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PlayGame game = (PlayGame) session.getAttribute("game");
        Integer winner = (Integer) session.getAttribute("winner");
        User user = (User) session.getAttribute("User");

        //add w/l/t to user record
        switch (winner){
            case 2: user.incWins();
            case 3: user.incLoses();
        }

        //add payout to user record
        user.addToBank((Double) session.getAttribute("payout"));
        registration.updateUser(user);

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}
