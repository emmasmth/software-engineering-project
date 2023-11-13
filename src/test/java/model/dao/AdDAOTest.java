package model.dao;

import model.entity.Ad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdDAOTest
{
    public static AdDAO dao = new AdDAO();

    @Test
    public void createAd()
    {
        String expectedName = "test";

        Ad ad = new Ad();
        ad.setFilename(expectedName);

        Ad createdAd = dao.create(ad);

        assertAll(
                () -> assertNotNull(createdAd.getID()),
                () -> assertEquals(createdAd.getFilename(), expectedName)
        );

        dao.deleteAll();
    }

}
