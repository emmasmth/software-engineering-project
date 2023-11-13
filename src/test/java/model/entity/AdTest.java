package model.entity;

import org.hibernate.engine.jdbc.ReaderInputStream;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

public class AdTest
{
    @Test
    public void testEmptyAd()
    {
        Ad ad = new Ad();
        assertAll(
                () -> assertNull(ad.getID()),
                () -> assertNull(ad.getFilename())
        );
    }

    @Test
    public void testAdConstructor()
    {
        Ad ad = new Ad("test.png");
        assertAll(
                () -> assertNull(ad.getID()),
                () -> assertEquals(ad.getFilename(), "test.png")
        );
    }

    @Test
    public void setAd()
    {
        int expectedID = 54;
        String expectedName = "test.png";

        Ad ad = new Ad();
        ad.setID(expectedID);
        ad.setFilename(expectedName);

        assertAll(
                () -> assertEquals(ad.getID(), expectedID),
                () -> assertEquals(ad.getFilename(), expectedName)
        );
    }
}

