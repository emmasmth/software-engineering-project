package controller.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Ad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito.*;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class DeleteAdServletTest {

    @Test
    public void deleteAdServletTest() throws IOException
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        DeleteAdServlet servlet = new DeleteAdServlet();
        Ad ad = mock(Ad.class);
        servlet.doPost(request, response);

        when(request.getParameter("idAdUploads")).thenReturn("67");

    }

}

