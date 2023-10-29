package controller.servlet;

import controller.Registration;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDAO;
import model.entity.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
public class RegistrationServletTest {

    @Test
    public void testPost() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        Registration register = mock(Registration.class);
        when(register.registerUser(any(User.class))).thenReturn(new User());

        RegistrationServlet servlet = new RegistrationServlet(register);

        when(request.getParameter("name")).thenReturn("Test");
        when(request.getParameter("username")).thenReturn("test@gmail.com");
        when(request.getParameter("password")).thenReturn("Test123");

        doNothing().when(response).sendRedirect(anyString());

        servlet.doPost(request, response);

        assertDoesNotThrow(
                () -> verify(response).sendRedirect("index.jsp")
        );
    }



}
