package controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class LogoutServletTest {

    @Test public void testLogout() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        when(request.getSession()).thenReturn(sessionMock);

        doNothing().when(sessionMock).invalidate();

        LogoutServlet servlet = new LogoutServlet();
        servlet.doGet(request, response);

        assertDoesNotThrow(
                () -> verify(response).sendRedirect("index.jsp")
        );

    }
}
