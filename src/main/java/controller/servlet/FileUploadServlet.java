package controller.servlet;

import model.entity.Ad;
import model.dao.AdDAO;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.sql.Blob;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.imageio.ImageIO;


@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            Part filePart = request.getPart("file");

            String filename = request.getParameter("filename");
            //String filepath = "/src/main/webapp/adimages/" + filename;

            InputStream fileContent = filePart.getInputStream();

            BufferedImage bufferedImage = ImageIO.read(fileContent);

            //@FIXME this should be an absolute path
            String uploadString = "/Users/emmasmith/IdeaProjects/software-engineering-project/src/main/webapp/adimages/";
            Path imgPath = Path.of(uploadString, filename);

            ImageIO.write(bufferedImage, "png", imgPath.toFile());

            byte[] fileBytes = fileContent.readAllBytes();
            Blob fileBlob = new javax.sql.rowset.serial.SerialBlob(fileBytes);

            Ad ad = new Ad();
            ad.setFilename(filename);
            ad.setFilepath(imgPath.toString());
            ad.setFilecontents(fileBlob);

            AdDAO adDAO = new AdDAO();
            adDAO.create(ad);

            response.sendRedirect("admin.jsp"); // Redirect to a success page
        }
        catch (Exception e)
        {
            e.printStackTrace();
            response.sendRedirect("adCreate.jsp"); // Redirect to an error page
        }

    }

}
