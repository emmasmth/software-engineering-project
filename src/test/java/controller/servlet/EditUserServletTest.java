package controller.servlet;

import controller.Registration;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDAO;
import model.entity.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EditUserServletTest {
    @Test public void testPost() throws IOException{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        Registration register = mock(Registration.class);
        EditUserServlet servlet = new EditUserServlet();
        servlet.setRegistration(register);

        when(request.getParameter("name")).thenReturn("Test");
        when(request.getParameter("editedID")).thenReturn("1");
        when(request.getParameter("editedName")).thenReturn("Test");
        when(request.getParameter("editedUsername")).thenReturn("32@gmail.com");
        when(request.getParameter("editedPass")).thenReturn("Test123");
        when(request.getParameter("editedPermission")).thenReturn("2");
        when(request.getParameter("editedWins")).thenReturn("2");
        when(request.getParameter("editedLosses")).thenReturn("2");
        when(register.editUser(any(User.class))).thenReturn(new User());

        doNothing().when(response).sendRedirect(anyString());

        servlet.doPost(request, response);

        assertDoesNotThrow(
                () -> verify(response).sendRedirect("manageUser.jsp")
        );


    }

}
