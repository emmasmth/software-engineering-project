package controller;

import model.dao.UserDAO;
import model.entity.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest {

    @Test public void registerUserTest(){
        User newUser = new User(1, "Test", "test@gmail.com", "DA13", User.USER_PERMISSION);

        UserDAO mockDAO = mock(UserDAO.class);
        when(mockDAO.create(any(User.class))).thenReturn(newUser);
        Registration registration = new Registration();
        registration.setDAO(mockDAO);

        User registeredNewUser = registration.registerUser(newUser);

       assertEquals(registeredNewUser.getID(), newUser.getID());

    }

    @Test public void registerUserCatchTest(){
        User newUser = new User();

        UserDAO mockDAO = mock(UserDAO.class);
        when(mockDAO.create(any(User.class))).thenThrow(new javax.persistence.PersistenceException());
        Registration registration = new Registration();
        registration.setDAO(mockDAO);

        User registeredNewUser = registration.registerUser(newUser);

        assertNull(registeredNewUser);



    }

    @Test public void loginUserTest(){
        String username = "test@gmail.com";
        String pass = "test123";
        User newUser = new User(1, "Test", username, pass, User.USER_PERMISSION);
        UserDAO mockDAO = mock(UserDAO.class);

        when(mockDAO.findUserFromUsername(anyString())).thenReturn(newUser);
        Registration registration = new Registration();
        registration.setDAO(mockDAO);

        User logged = registration.loginUser(username, pass);

        assertEquals(logged.getLogin(), newUser.getLogin());
    }

}
