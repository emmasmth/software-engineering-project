package model.dao;

import model.entity.Ad;

import javax.imageio.IIOException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AdDAO extends GenericDAO<Ad>
{
    public AdDAO()
    {
        super(Ad.class);
    }

    @Override
    public void delete(int id) {
        Ad entity = read(id);
        String s = entity.getFilepath();
        Path p = Path.of(s);

        try
        {
            Files.deleteIfExists(p);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        delete(entity);
    }
}
