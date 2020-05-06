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

    public void deleteSondage(Sondage sondage) {
        EntityManagerHelper.beginTransaction();
        manager.remove(sondage);
        EntityManagerHelper.commit();
    }

    public Sondage updateSondage(Long id, Sondage sondageUpdated){
        manager.getTransaction().begin();
        Sondage sAUpdate = manager.find(Sondage.class,id);
        sAUpdate.setDates(sondageUpdated.getDates());
        sAUpdate.setCreateur(sondageUpdated.getCreateur());
        sAUpdate.setReunion(sondageUpdated.getReunion());
        manager.flush();
        manager.getTransaction().commit();
        return sondageUpdated;
    }

}
