package model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest
{
    @Test
    public void testEmptyUser()
    {
        User u = new User();
        assertAll(
                () -> assertNull(u.getID()),
                () -> assertNull(u.getName()),
                () -> assertNull(u.getLogin()),
                () -> assertNull(u.getPassword()),
                () -> assertEquals(u.getPermission(), User.USER_PERMISSION),
                () -> assertEquals(u.getPermissionAsString(), "User")
        );
    }

    @Test
    public void testEmptyConstructor()
    {
        User u = new User();
        assertEquals(u.getPermission(), User.USER_PERMISSION);
    }

    @Test
    public void testEmptyConstructorSetAttributes()
    {
        User u = new User();
        Integer expectedID = 404;
        u.setID(expectedID);

        String expectedName = "myname000";
        u.setName(expectedName);

        String expectedLogin = "mylogin123";
        u.setLogin(expectedLogin);

        String expectedPassword = "mypassword456";
        u.setPassword(expectedPassword);

        assertAll(
                () -> assertEquals(u.getID(), expectedID),
                () -> assertEquals(u.getName(), expectedName),
                () -> assertEquals(u.getLogin(), expectedLogin),
                () -> assertEquals(u.getPassword(), expectedPassword)
        );
    }

    @Test
    public void testConstructor()
    {
        User u = new User(101, "myname1", "test@test.com", "123456", User.ADMIN_PERMISSION);
        assertAll(
                () -> assertEquals(u.getID(), 101),
                () -> assertEquals(u.getLogin(), "test@test.com"),
                () -> assertEquals(u.getPassword(), "123456"),
                () -> assertEquals(u.getPermission(), User.ADMIN_PERMISSION),
                () -> assertEquals(u.getPermissionAsString(), "Admin")
        );
    }


    @Test
    public void testConstructor2()
    {
        Integer expectedID = 1;
        String expectedName = "testname";
        String expectedLogin = "testlogin";
        String expectedPassword = "testpassword";
        int expectedPermission = 1;

        User user = new User(expectedID, expectedName, expectedLogin, expectedPassword, expectedPermission);

        assertAll(
                () -> assertEquals(expectedID, user.getID()),
                () -> assertEquals(expectedLogin, user.getLogin()),
                () -> assertEquals(expectedPassword, user.getPassword()),
                () -> assertEquals(expectedPermission, user.getPermission())
        );
    }

    @Test
    public void testUnknownPermissionString()
    {
        User u = new User();
        u.setPermission(-1);
        assertEquals(u.getPermissionAsString(), "Unknown");
    }
}

