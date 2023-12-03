package model.entity;

import javax.persistence.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

@Entity
public class Ad extends BaseEntity
{
    @Id @Column (name = "idAdUploads") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdUploads = null;

    @Column
    private String filename;

    @Column
    private String filepath;

    @Column Blob filecontents;


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

    public String getFilepath()
    {
        return filepath;
    }

    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }

    public Blob getFilecontents()
    {
        return filecontents;
    }

    public void setFilecontents(Blob blob)
    {
        this.filecontents = blob;
    }

    public boolean isMyID(int otherid)
    {
        return getID() == otherid;
    }

}
