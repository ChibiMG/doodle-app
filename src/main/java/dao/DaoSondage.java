package dao;

import jpa.*;

import javax.persistence.EntityManager;

import java.util.List;

public class DaoSondage {

    private EntityManager manager = EntityManagerHelper.getEntityManager();


    public List<Sondage> getAll() {
         return manager.createQuery("Select s From Sondage s", Sondage.class).getResultList();
    }

    public Sondage createSondage(Sondage sondage) {
        EntityManagerHelper.beginTransaction();
        manager.persist(sondage);
        EntityManagerHelper.commit();
        return sondage;
    }


    public Sondage getSondageById(Long id){
        return manager.createQuery("Select s From Sondage s where s.id= :id", Sondage.class).setParameter("id", id).getSingleResult();
    }


}
