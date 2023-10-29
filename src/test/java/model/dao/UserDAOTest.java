package model.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.entity.User;

public class UserDAOTest {

    public static UserDAO dao = null;

    public static User createUserEntity(){
        User user = new User();
        user.setName("Oliver");
        user.setLogin("asdad@gmail.com");
        user.setPassword("test123");
        user.setPermission(User.USER_PERMISSION);
        return user;
    }
    public static User createUserEntityDifferent(){
        User user = new User();
        user.setName("John");
        user.setLogin("park@gmail.com");
        user.setPassword("test123");
        user.setPermission(User.USER_PERMISSION);
        return user;
    }

    @BeforeAll public static void createTestDAO(){
        dao = new UserDAO();
        dao.setDbTypeOutput(GenericDAO.DbType.TEST);
    }

    @BeforeEach public void clearBefore(){
        dao.deleteAll();
    }


    @Test public void createUserTest(){
        User newUser = createUserEntity();
        dao.create(newUser);
        User userInserted = dao.read(newUser.getID());
        assertAll(
                () -> assertNotNull(userInserted, "If we added a user to the database they should exist"),
                () -> assertEquals(userInserted.getID(), newUser.getID(), "ID of the user we extracted from database should match the ID of the entity"),
                () -> assertEquals(userInserted.getName(), newUser.getName(), "Name of the user we extracted from database should match the Name of the entity"),
                () -> assertEquals(userInserted.getLogin(), newUser.getLogin(), "Login of the user we extracted from database should match the Login of the entity"),
                () -> assertEquals(userInserted.getPassword(), newUser.getPassword(), "Password of the user we extracted from database should match the Password of the entity")
                );
    }
    @Test public void deleteEmptyDAOTest(){
        User newuser = createUserEntity();
        assertDoesNotThrow(() -> dao.delete(newuser));
    }


    @Test public void deleteUserTest(){
        User newUser = createUserEntity();
        dao.create(newUser);
        dao.delete(newUser.getID());
        assertNull(dao.read(newUser.getID()), "User should not exist after deletion");
    }

    @Test public void deleteAllTest(){
        User newUser = createUserEntity();
        User differentUser = createUserEntityDifferent();
        dao.create(newUser);
        dao.create(differentUser);
        dao.deleteAll();
        assertNull(dao.read(newUser.getID()), "User should not exist after deletion");
        assertNull(dao.read(differentUser.getID()), "User should not exist after deletion");
    }

    @Test public void updateEntityTest(){
        User newUser = createUserEntity();
        dao.create(newUser);
        newUser.setName("Update");
        dao.update(newUser);
        User record = dao.read(newUser.getID());
        assertEquals(record.getName(), "Update");
    }

    @Test public void ListTest(){
        User newUser = createUserEntity();
        User differentUser = createUserEntityDifferent();
        dao.create(newUser);
        dao.create(differentUser);
        java.util.List<User> userList = dao.list("idUser");

        assertAll(
                () -> assertEquals(userList.size(), 2),
                () -> assertEquals(userList.get(0).getName(), "Oliver"),
                () -> assertEquals(userList.get(1).getName(), "John")
                );
    }

    @Test public void ListTestNonExistingOrder(){
        User newUser = createUserEntity();
        User differentUser = createUserEntityDifferent();
        dao.create(newUser);
        dao.create(differentUser);

        assertThrows(javax.persistence.PersistenceException.class, () -> dao.list("random"));

    }

    @Test public void userRegistered(){
        User newUser = createUserEntity();
        dao.create(newUser);
        User registered = dao.read(newUser.getID());
        assertAll(
                () -> assertNotNull(registered.getLogin()),
                () -> assertNotNull(registered.getPassword())
                );
    }

    @Test public void testLogin(){
        User newUser = createUserEntity();

        dao.create(newUser);
        User checkLogged = dao.findUserFromUsername(newUser.getLogin());
        assertNotNull(checkLogged.getID());
    }
}
