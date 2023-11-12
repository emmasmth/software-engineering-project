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



public class StartServletTest {


    @Test public void testGet() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);
        when(request.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("game")).thenReturn(null);
        PlayGame game = mock(PlayGame.class);
        doNothing().when(game).play();

        StartServlet servlet = new StartServlet();
        servlet.setGame(game);

        servlet.doGet(request, response);

        assertAll(
                () -> verify(sessionMock).setAttribute(eq("game"), any(PlayGame.class)),
                () -> assertNotNull(game),
                () -> verify(response).sendRedirect("continue.jsp")

        );


    }



    @Test public void testClearHands() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);
        when(request.getSession()).thenReturn(sessionMock);
        PlayGame game = mock(PlayGame.class);
        when(sessionMock.getAttribute("game")).thenReturn(game);

        doNothing().when(game).clearHands();

        StartServlet servlet = new StartServlet();
        servlet.setGame(game);

        servlet.doGet(request, response);

        assertAll(
                () -> assertNotNull(game),
                () -> verify(response).sendRedirect("continue.jsp")

        );


    }


}
