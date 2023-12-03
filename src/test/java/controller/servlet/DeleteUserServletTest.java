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
public class DeleteUserServletTest {

    @Test public void deleteUserServletTest() throws IOException{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        DeleteUserServlet servlet = new DeleteUserServlet();
        Registration register = mock(Registration.class);
        servlet.setRegistration(register);

        when(request.getParameter("id")).thenReturn("81");
        doNothing().when(register).deleteUser(anyInt());

        servlet.doGet(request, response);

        verify(register, times(1)).deleteUser(81);
    }
}
