package controller.servlet;
import java.io.*;
import controller.PlayGame;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "OutcomeServlet", value = "/OutcomeServlet")
public class OutcomeServlet extends HttpServlet{
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PlayGame game = (PlayGame) session.getAttribute("game");

        //add w/l/t to user record

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}
