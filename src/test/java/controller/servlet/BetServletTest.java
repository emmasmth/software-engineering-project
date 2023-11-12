package controller.servlet;

import controller.PlayGame;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BetServletTest {

    @Test
    public void testValidBet() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("betAmount")).thenReturn("100");

        PlayGame game = new PlayGame();
        when(session.getAttribute("game")).thenReturn(game);

        BetServlet servlet = new BetServlet();
        servlet.doPost(request, response);

        verify(session).setAttribute(eq("betAmount"), eq(100.0));
        verify(session).setAttribute(eq("game"), any(PlayGame.class));
        verify(response).sendRedirect("continue.jsp");
    }

    @Test
    public void testInvalidBet() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("betAmount")).thenReturn("invalid");

        BetServlet servlet = new BetServlet();
        servlet.doPost(request, response);

        verify(response).sendRedirect("betting.jsp?error=InvalidBetAmount");
    }
}
