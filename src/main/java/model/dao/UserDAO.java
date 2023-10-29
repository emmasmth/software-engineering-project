package model.dao;

import model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UserDAO extends GenericDAO<User> {

    public UserDAO() {
        super(User.class);
    }

    public User findUserFromUsername(String username) {
        EntityManager entityManager = getEntityManager();

        String query = "SELECT u FROM " + getTableName() + " u WHERE u.Login = :email";
        User located = null;

        try {
            located = entityManager.createQuery(query, User.class).setParameter("email", username).getSingleResult();
        } catch (NoResultException exception) {
            located = null;
        } finally {
            entityManager.close();
        }
        return located;
    }
}
