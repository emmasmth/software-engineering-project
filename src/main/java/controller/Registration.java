package controller;
import model.entity.User;
import model.dao.UserDAO;

public class Registration {

    public UserDAO dao = new UserDAO();

    public void setDAO(UserDAO dao){
        this.dao = dao;
    }

    public User registerUser(User user){
        try{
            user = dao.create(user);
        }
        catch (javax.persistence.PersistenceException exception){
            user = null;
        }
        finally {
            return user;
        }
    }

    public User loginUser(String login, String password){
        User find = dao.findUserFromUsername(login);
        if(find != null && find.getPassword().equals(password)){
            return find;
        }
        return null;
    }

}

