package model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test public void blankUser (){
        User user = new User();
        assertAll(
                () -> assertNull(user.getID()),
                () -> assertNull(user.getName()),
                () -> assertNull(user.getLogin()),
                () -> assertNull(user.getPassword()),
                () -> assertEquals(user.getPermission(), User.USER_PERMISSION),
                () -> assertEquals(user.toString(), "Player")
        );

    }

    @Test public void newUser (){
        User newUser = new User(5, "Oliver", "oliver@gmail.com", "Pr123", User.ADMIN_PERMISSION);
        assertAll(
                () -> assertEquals(newUser.getID(), 5),
                () -> assertEquals(newUser.getName(), "Oliver"),
                () -> assertEquals(newUser.getLogin(), "oliver@gmail.com"),
                () -> assertEquals(newUser.getPassword(), "Pr123"),
                () -> assertEquals(newUser.getPermission(), User.ADMIN_PERMISSION),
                () -> assertEquals(newUser.toString(), "Admin")
        );
    }

    @Test public void newUserUsingMethods (){
        User newUser = new User();
        newUser.setID(3);
        newUser.setName("Test");
        newUser.setLogin("test@gmail.com");
        newUser.setPassword("Test123");
        newUser.setPermission(User.ADMIN_PERMISSION);
        assertAll(
                () -> assertEquals(newUser.getID(), 3),
                () -> assertEquals(newUser.getName(), "Test"),
                () -> assertEquals(newUser.getLogin(), "test@gmail.com"),
                () -> assertEquals(newUser.getPassword(), "Test123"),
                () -> assertEquals(newUser.getPermission(), User.ADMIN_PERMISSION),
                () -> assertEquals(newUser.toString(), "Admin")
        );
    }

    @Test public void permissionNotRecognized(){
        User newUser = new User();
        newUser.setPermission(9);
        assertEquals(newUser.toString(), "Unknown");

    }


}
