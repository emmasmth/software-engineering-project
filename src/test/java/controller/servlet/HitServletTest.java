package controller.servlet;

import controller.PlayGame;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;



public class HitServletTest {

    //Cant get above 50% coverage because when(sessionMock.getAttribute("game")).thenReturn(game);
    // game will be null since its a mock

    @Test public void testGet() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);
        PlayGame game = mock(PlayGame.class);

        when(request.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("game")).thenReturn(game);
        when(game.playerTotal()).thenReturn(4);


        HitServlet servlet = new HitServlet();
        servlet.setGame(game);
        servlet.doGet(request, response);

        assertAll(
                () -> assertNotNull(game),
                () -> verify(response).sendRedirect("continue.jsp"),
                () -> verify(game, times(1)).playerTurn()

        );
    }
}
