package controller.servlet;

import jakarta.servlet.RequestDispatcher;
import model.entity.Ad;
import controller.Passwords;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    private static final String url = "jdbc:mysql://localhost:3306/Ad";

    public Ad ad;
    protected Passwords pw;
    String myuser;
    String mypw;

    public FileUploadServlet() throws ServletException
    {
        ad = new Ad();

        pw = new Passwords();
        myuser = pw.getUser();
        mypw = pw.getPass();
    }
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

        Ad ad = new Ad(filename);
        byte[] filedata = ad.getFileData();
        ad.setFiledata(filedata);

        try(Connection connection = DriverManager.getConnection(url, myuser, mypw))
        {
            String sql = "INSERT INTO Ad (filename, filedata) VALUES (?, ?)";
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

        response.sendRedirect("adDelete.jsp");

    }

}
