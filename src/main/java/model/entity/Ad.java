package model.entity;

import javax.persistence.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Entity
public class Ad extends BaseEntity
{
    @Id @Column (name = "idAdUploads") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdUploads = null;

    @Column
    private String filename;

    @Column @Lob
    private byte[] filedata;


    public Ad()
    {

    }

    public Ad(String filename)
    {
        this.filename = filename;
    }

    @Override
    public Integer getID()
    {
        return idAdUploads;
    }

    public void setID(Integer idAdUploads)
    {
        this.idAdUploads = idAdUploads;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }


    public byte[] getFileData()
    {
        byte[] fileBytes = null;

        try
        {
            fileBytes = readFileToByteArray(filename);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return fileBytes;
    }

    public void setFiledata(byte[] filedata)
    {
        this.filedata = filedata;
    }

    private static byte[] readFileToByteArray(String filePath) throws IOException
    {
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }

}