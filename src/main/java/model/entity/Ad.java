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
    private Integer idAdUploads;

    @Column
    private String filename;

    @Column
    private InputStream filedata;


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


    public InputStream getFileData()
    {
        return this.filedata;
    }

    public void setFiledata(InputStream filedata)
    {
        this.filedata = filedata;
    }

}
