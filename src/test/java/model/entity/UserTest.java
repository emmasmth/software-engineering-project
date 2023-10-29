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
                () -> assertNull(u.getLogin()),
                () -> assertNull(u.getPassword()),
                () -> assertEquals(u.getPermission(), User.USER_PERMISSION),
                () -> assertEquals(u.getPermissionAsString(), "User")
        );
    }

    @Test
    public void testConstructor()
    {
        User u = new User(101, "test@test.com", "123456", User.ADMIN_PERMISSION);
        assertAll(
                () -> assertEquals(u.getID(), 101),
                () -> assertEquals(u.getLogin(), "test@test.com"),
                () -> assertEquals(u.getPassword(), "123456"),
                () -> assertEquals(u.getPermission(), User.ADMIN_PERMISSION),
                () -> assertEquals(u.getPermissionAsString(), "Admin")
        );
    }
}
