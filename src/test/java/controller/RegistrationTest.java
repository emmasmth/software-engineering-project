package controller;

import model.dao.UserDAO;
import model.entity.User;
import org.junit.jupiter.api.Test;
import util.PasswordUtil;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest {

    @Test
    public void registerUserTest() {
        User newUser = new User(1, "Test", "test@gmail.com", "DA13", User.USER_PERMISSION);

        UserDAO mockDAO = mock(UserDAO.class);
        when(mockDAO.create(any(User.class))).thenReturn(newUser);
        Registration registration = new Registration();
        registration.setDAO(mockDAO);

        User registeredNewUser = registration.registerUser(newUser);

        assertEquals(registeredNewUser.getID(), newUser.getID());

    }

    @Test
    public void registerUserCatchTest() {
        User newUser = new User();

        UserDAO mockDAO = mock(UserDAO.class);
        when(mockDAO.create(any(User.class))).thenThrow(new javax.persistence.PersistenceException());
        Registration registration = new Registration();
        registration.setDAO(mockDAO);

        User registeredNewUser = registration.registerUser(newUser);

        assertNull(registeredNewUser);


    }

    @Test
    public void loginUserTest() {
        String username = "test@gmail.com";
        String pass = "test123";
        String hashed = PasswordUtil.hash(pass);
        User newUser = new User(1, "Test", username, hashed, User.USER_PERMISSION);
        UserDAO mockDAO = mock(UserDAO.class);

        when(mockDAO.findUserFromUsername(anyString())).thenReturn(newUser);
        Registration registration = new Registration();
        registration.setDAO(mockDAO);

        User logged = registration.loginUser(username, pass);

        assertEquals(logged.getLogin(), newUser.getLogin());
    }

    @Test
    public void listUserTest() {
        Registration register = new Registration();
        UserDAO mockDAO = mock(UserDAO.class);
        register.setDAO(mockDAO);
        when(mockDAO.list(anyString())).thenReturn(new ArrayList<User>());
        List<User> lst = register.listUsers("test");
        assertNotNull(lst);
    }

    @Test
    public void editUserNullPassTest(){
        Registration register = new Registration();
        UserDAO mockDAO = mock(UserDAO.class);

        User user = new User(1, "Test", "username@gmail.com", PasswordUtil.hash("test"), User.USER_PERMISSION);
        User edited = new User(1, "EDITEDTEST", "TEST@gmail.com", null, User.USER_PERMISSION);
        register.setDAO(mockDAO);

        when(mockDAO.read(anyInt())).thenReturn(user);
        when(mockDAO.update(any(User.class))).thenReturn(edited);
        register.editUser(edited);
        assertAll(
                () -> assertEquals(edited.getPassword(), user.getPassword()),
                () -> assertDoesNotThrow(
                        () -> verify(mockDAO).read(eq(edited.getID()))),
                () -> assertDoesNotThrow(
                        () -> verify(mockDAO).update(any(User.class)))

                );

    }

    @Test
    public void editUserPassTest(){
        Registration register = new Registration();
        UserDAO mockDAO = mock(UserDAO.class);
        String pass = "test";
        User edited = new User(1, "EDITEDTEST", "TEST@gmail.com", pass, User.USER_PERMISSION);
        register.setDAO(mockDAO);

        when(mockDAO.update(any(User.class))).thenReturn(edited);
        register.editUser(edited);
        assertNotEquals(edited.getPassword(), pass);

    }
}