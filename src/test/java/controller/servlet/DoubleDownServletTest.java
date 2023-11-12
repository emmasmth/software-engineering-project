package controller.servlet;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import controller.PlayGame;

public class DoubleDownServletTest {

    @Test
    public void testDoubleDown() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        PlayGame game = mock(PlayGame.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(game);
        when(game.getBet()).thenReturn(100.0); // Initial bet amount before doubling

        DoubleDownServlet servlet = new DoubleDownServlet();
        servlet.doGet(request, response);

        verify(game).setBet(200.0); // Verify the bet is doubled
        verify(game).playerTurn(); // Verify a card is dealt to the player
        verify(session).setAttribute("betAmount", 100.0); // Verify the session is updated with the doubled bet amount
        verify(session).setAttribute("game", game); // Verify the updated game is set in the session
        verify(response).sendRedirect("continue.jsp"); // Verify redirection
    }



    @Test
    public void testGameNull() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(null);

        DoubleDownServlet servlet = new DoubleDownServlet();
        servlet.doGet(request, response);

        verify(response).sendRedirect("index.jsp"); // Verify that the response is redirected when the game is null
    }
}
