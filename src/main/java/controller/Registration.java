package controller;

import model.entity.User;
import model.dao.UserDAO;
import util.PasswordUtil;

import java.util.List;

public class Registration {

    public static UserDAO dao = new UserDAO();

    public void setDAO(UserDAO dao){
        Registration.dao = dao;
    }

    public User registerUser(User user){
        try{
            String hashed = PasswordUtil.hash(user.getPassword());
            user.setPassword(hashed);
            user = dao.create(user);
        }
        catch (javax.persistence.PersistenceException exception){
            user = null;
            System.out.println(exception);
        }
        return user;

    }

    public User loginUser(String login, String password)
    {
        User find = dao.findUserFromUsername(login);
        if(find != null)
        {
            if(PasswordUtil.compare(password, find.getPassword()))
            {
                return find;
            }

        }
        return null;
    }

    public static List<User> listUsers(String order)
    {
        List<User> lstUser = dao.list(order);
        return lstUser;
    }

    public static void deleteUser(int id)
    {
        dao.delete(id);
    }

    public static User editUser(User u)
    {
        if(u.getPassword() == null || u.getPassword().trim().length() == 0)
        {
            User og = dao.read(u.getID());
            u.setPassword(og.getPassword());
        }
        else
        {
            String hashed = PasswordUtil.hash(u.getPassword());
            u.setPassword(hashed);
        }
        return dao.update(u);
    }

}

