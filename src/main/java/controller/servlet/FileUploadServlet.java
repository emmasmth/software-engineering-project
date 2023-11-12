package controller.servlet;

import model.entity.Ad;
import controller.EmmasPasswords;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.io.ByteArrayOutputStream;

import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet (name = "FileUploadServlet", urlPatterns = {"/fileuploadservlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class FileUploadServlet extends HttpServlet
{
    private static final String url = "jdbc:mysql://localhost:3306/AdUploads";

    EmmasPasswords ep = new EmmasPasswords();
    private final String user = ep.getUser();
    private final String pass = ep.getPass();

    public Ad ad = new Ad();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String filename = request.getParameter("filename");
        this.ad.setFilename(filename);
        System.out.println(this.ad.getFilename());
        response.sendRedirect("adDelete.jsp");
        Ad ad = new Ad(filename);
        byte[] filedata = ad.getFileData();
        ad.setFiledata(filedata);

        try(Connection connection = DriverManager.getConnection(url, user, pass))
        {
            String sql = "INSERT INTO AdUploads (filename, filedata) VALUES (?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(sql))
            {
                statement.setString(1, ad.getFilename());
                statement.setBytes(2, ad.getFileData());
                statement.executeUpdate();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }



    }

}
