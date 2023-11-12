package model.dao;

import model.entity.Ad;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class AdDAO extends GenericDAO<Ad>
{
    public AdDAO()
    {
        super(Ad.class);
    }
}
