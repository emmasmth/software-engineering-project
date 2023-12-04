package model.dao;

import model.entity.Ad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdDAOTest
{
    public static AdDAO dao = new AdDAO();

    @Test
    public void createAd()
    {
        String expectedName = "test";
        String expectedPath = "/Users/emmasmith/IdeaProjects/software-engineering-project/src/main/webapp/adimages/expectedName";

        Ad ad = new Ad();
        ad.setFilename(expectedName);
        ad.setFilepath(expectedPath);

        Ad createdAd = dao.create(ad);

        assertAll(
                () -> assertNotNull(createdAd.getID()),
                () -> assertEquals(createdAd.getFilename(), expectedName),
                () -> assertEquals(createdAd.getFilepath(), expectedPath)
        );

        dao.deleteAll();
    }

    @Test
    public void read()
    {
        String expectedName = "test";
        String expectedPath = "/Users/emmasmith/IdeaProjects/software-engineering-project/src/main/webapp/adimages/expectedName";

        Ad ad = new Ad();
        ad.setFilename(expectedName);
        ad.setFilepath(expectedPath);

        Ad createdAd = dao.create(ad);

        assertAll(
                () -> assertEquals(dao.read(ad.getID()).getID(), createdAd.getID()),
                () -> assertEquals(dao.read(ad.getID()).getFilename(), createdAd.getFilename()),
                () -> assertEquals(dao.read(ad.getID()).getFilepath(), createdAd.getFilepath())
        );
    }


    @Test
    public void readAd()
    {
        String expectedName = "test";
        String expectedPath = "/Users/emmasmith/IdeaProjects/software-engineering-project/src/main/webapp/adimages/expectedName";

        Ad ad = new Ad();
        ad.setFilename(expectedName);
        ad.setFilepath(expectedPath);

        Ad createdAd = dao.create(ad);

        assertAll(
                () -> assertEquals(dao.read(ad).getID(), createdAd.getID()),
                () -> assertEquals(dao.read(ad).getFilename(), createdAd.getFilename()),
                () -> assertEquals(dao.read(ad).getFilepath(), createdAd.getFilepath())
        );
    }

    @Test
    public void update()
    {
        String expectedName = "test";
        String expectedPath = "/Users/emmasmith/IdeaProjects/software-engineering-project/src/main/webapp/adimages/expectedName";

        Ad ad = new Ad();
        ad.setFilename(expectedName);
        ad.setFilepath(expectedPath);

        Ad createdAd = dao.create(ad);

        Ad updateme = new Ad();
        updateme.setID(createdAd.getID());
        updateme.setFilename("new");
        updateme.setFilepath("newpath");

        dao.update(updateme);

        assertAll(
                () -> assertEquals(updateme.getID(), createdAd.getID()),
                () -> assertEquals(updateme.getFilename(), "new"),
                () -> assertEquals(updateme.getFilepath(), "newpath")
        );
    }

    @Test
    public void testDelete()
    {
        String expectedName = "test";
        String expectedPath = "/Users/emmasmith/IdeaProjects/software-engineering-project/src/main/webapp/adimages/expectedName";

        Ad ad = new Ad();
        ad.setFilename(expectedName);
        ad.setFilepath(expectedPath);

        int IDval = -1;

        if(ad.getID() != null)
            IDval = ad.getID();

        Ad createdAd = dao.create(ad);
        dao.delete(createdAd.getID());

        assertNull(dao.read(IDval));
    }
}