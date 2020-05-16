package dao;

import jpa.Date;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import java.util.List;


public class DaoDate {
    private EntityManager manager = EntityManagerHelper.getEntityManager();

    public Date getDateById(Long id){
        return manager.createQuery("Select d From Date d where d.id= :id", Date.class).setParameter("id", id).getSingleResult();
    }

    public List<Date> getDatesForSondageId(Long id){
        return manager.createQuery("Select d From Date d Left Join Sondage s where s.id = :id", Date.class).setParameter("id", id).getResultList();
    }

    public Date createDate(Date date) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(date);
        EntityManagerHelper.commit();
        return date;
    }
}
