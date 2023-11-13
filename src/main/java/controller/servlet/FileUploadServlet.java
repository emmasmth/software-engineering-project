package controller.servlet;

import model.entity.Ad;
import model.dao.AdDAO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            Part filePart = request.getPart("file");

            InputStream fileContent = filePart.getInputStream();
            byte[] fileBytes = fileContent.readAllBytes();
            Blob fileBlob = new javax.sql.rowset.serial.SerialBlob(fileBytes);

            Ad ad = new Ad();
            ad.setFilename("EMMA.png");
            ad.setFilecontents(fileBlob);

            AdDAO adDAO = new AdDAO();
            adDAO.create(ad);

            response.sendRedirect("temppage.jsp"); // Redirect to a success page
        }
        catch (Exception e)
        {
            e.printStackTrace();
            response.sendRedirect("adCreate.jsp"); // Redirect to an error page
        }
    }
}

