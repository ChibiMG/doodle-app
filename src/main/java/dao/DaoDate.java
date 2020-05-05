package dao;

import jpa.Date;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;

public class DaoDate {
    private EntityManager manager = EntityManagerHelper.getEntityManager();

    public Date getDateById(Long id){
        return manager.createQuery("Select d From Date d where d.id= :id", Date.class).setParameter("id", id).getSingleResult();
    }
}
