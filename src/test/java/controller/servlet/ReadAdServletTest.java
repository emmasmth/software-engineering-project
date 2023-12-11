package controller.servlet;

import controller.AdService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Ad;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class ReadAdServletTest {

    @Test
    void testDoGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ReadAdServlet servlet = new ReadAdServlet();
        Ad ad = mock(Ad.class);
        servlet.doGet(request, response);

        when(request.getParameter("idAdUploads")).thenReturn("67");
    }

    // You can write more tests to cover other scenarios as needed
}
