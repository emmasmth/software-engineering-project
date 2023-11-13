package controller.servlet;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;

public class FileUploadServletTest
{
    @Test
    public void testDoPost() throws ServletException, IOException
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getPart("file")).thenReturn(mock(Part.class));
        when(request.getPart("fileContent")).thenReturn(mock(Part.class));

        FileUploadServlet servlet = new FileUploadServlet();
        servlet.doPost(request, response);

        doNothing().when(response).sendRedirect(anyString());

        servlet.doPost(request, response);

        assertDoesNotThrow(
                () -> verify(response).sendRedirect("temppage.jsp")
        );
    }

}
