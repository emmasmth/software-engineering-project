package controller;
import model.entity.User;
import model.dao.UserDAO;

public class Registration {

    public static UserDAO dao = new UserDAO();

    public static void register(User user){
        dao.create(user);
    }

}

