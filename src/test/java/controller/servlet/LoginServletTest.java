package controller.servlet;
import controller.Registration;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import model.dao.UserDAO;
import model.entity.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginServletTest {
    @Test
    public void loginPostTestFail() throws IOException, ServletException {
        // Create a User object
        User user = new User();
        user.setID(200);
        user.setLogin("test@gmail.com");
        user.setPassword("Test123");

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        when(request.getSession()).thenReturn(sessionMock);

        when(request.getParameter("username")).thenReturn("test@gmail.com");
        when(request.getParameter("password")).thenReturn("Test123");

        doNothing().when(response).sendRedirect(anyString());


        doNothing().when(sessionMock).setAttribute(anyString(), any(User.class));

        Registration test = mock(Registration.class);
        UserDAO mockDAO = mock(UserDAO.class);
        test.setDAO(mockDAO);

        when(test.loginUser(eq("test@gmail.com"), eq("Test123"))).thenReturn(null);

        LoginServlet servlet = new LoginServlet();

        servlet.doPost(request, response);


        verify(response).sendRedirect("login.jsp?loginFail=1");
    }


    @Test
    public void loginPostTestSuccess() throws IOException, ServletException {
        // Create a User object
        User user = new User();
        user.setID(200);
        user.setLogin("test@gmail.com");
        user.setPassword("Test123");

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);


        when(request.getParameter("username")).thenReturn("test@gmail.com");
        when(request.getParameter("password")).thenReturn("Test123");
        when(request.getSession()).thenReturn(sessionMock);


        Registration test = mock(Registration.class);

        when(test.loginUser(anyString(), anyString())).thenReturn(user);

        LoginServlet servlet = new LoginServlet();
        servlet.setRegistration(test);

        servlet.doPost(request, response);


        verify(response).sendRedirect("advertisement.jsp");
    }
}
