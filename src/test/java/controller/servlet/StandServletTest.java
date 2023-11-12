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

public class StandServletTest {

    /*
    @Test
    public void testGameNotNull() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        PlayGame game = mock(PlayGame.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(game);
        when(game.determineWinner()).thenReturn(1);
        when(game.dealerTotal()).thenReturn(16);

        StandServlet servlet = new StandServlet();
        servlet.doPost(request, response);

        verify(game).setIsPlayersTurn(false);
        verify(game, atLeastOnce()).dealerTurn();
        verify(game).determineWinner();
        verify(session).setAttribute(eq("game"), any(PlayGame.class));
        verify(session).setAttribute(eq("winner"), anyInt());
        verify(response).sendRedirect("continue.jsp");
    }
*/
    @Test
    public void testGameNull() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("game")).thenReturn(null);

        StandServlet servlet = new StandServlet();
        servlet.doPost(request, response);

        verify(response).sendRedirect("index.jsp");
    }
}
