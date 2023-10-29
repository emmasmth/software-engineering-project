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



}
