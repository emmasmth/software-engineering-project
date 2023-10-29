package controller.servlet;
import controller.Registration;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import model.entity.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginServletTest {

    @Test
    public void loginPostTest() throws IOException, ServletException {
        User user = new User();
        user.setID(200);
        user.setLogin("test@gmail.com");
        user.setPassword("Test123");

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        doNothing().when(response).sendRedirect(anyString());

        doNothing().when(sessionMock).setAttribute(anyString(), any(User.class));

        Registration test = mock(Registration.class);

        when(test.loginUser(anyString(), anyString())).thenReturn(user);

        LoginServlet servlet = new LoginServlet();
        servlet.doPost(request, response);

        assertDoesNotThrow(
                () -> verify(sessionMock).setAttribute(eq("User"), any(User.class))
        );

    }


}
