package model.entity;

import javax.persistence.*;
import java.io.InputStream;

@Entity
public class Ad extends BaseEntity
{
    @Id @Column (name = "idAdUploads") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdUploads = null;

    @Column
    private String filename;

    @Column
    private InputStream filedata;

    public Ad(String filename, InputStream filedata)
    {
        this.filename = filename;
        this.filedata = filedata;
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

    public InputStream getFiledata()
    {
        return filedata;
    }

    public void setFiledata(InputStream filedata)
    {
        this.filedata = filedata;
    }

}
