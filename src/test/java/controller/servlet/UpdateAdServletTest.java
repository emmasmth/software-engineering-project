package controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Ad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito.*;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class UpdateAdServletTest {

    @Test
    public void updateAdServletTest() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        UpdateAdServlet servlet = new UpdateAdServlet();
        Ad ad = mock(Ad.class);
        servlet.doPost(request, response);

        when(request.getParameter("idAdUploads")).thenReturn("67");

    }

    @Test
    public void updateAdServletTestGet() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        UpdateAdServlet servlet = new UpdateAdServlet();
        Ad ad = mock(Ad.class);
        servlet.doGet(request, response);

        when(request.getParameter("idAdUploads")).thenReturn("67");

    }

}

