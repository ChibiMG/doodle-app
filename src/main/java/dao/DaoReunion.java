package dao;

import jpa.EntityManagerHelper;
import jpa.Reunion;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoReunion {
    private EntityManager manager = EntityManagerHelper.getEntityManager();

    public List<Reunion> getAll() {
        return manager.createQuery("Select r From Reunion r", Reunion.class).getResultList();
    }

    public Reunion createReunion(Reunion reunion) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(reunion);
        EntityManagerHelper.commit();
        return reunion;
    }

    public Reunion getReunionById(Long id){
        return manager.createQuery("Select r From Reunion r where r.id= :id", Reunion.class).setParameter("id", id).getSingleResult();
    }

    public void deleteReunion(Reunion reunion) {
        EntityManagerHelper.beginTransaction();
        manager.remove(reunion);
        EntityManagerHelper.commit();
    }

    public Reunion updateReunion(Long id, Reunion reuUpdated){
        manager.getTransaction().begin();
        Reunion rAUpdate = manager.find(Reunion.class,id);
        rAUpdate.setDateReunion(reuUpdated.getDateReunion());
        rAUpdate.setIntitule(reuUpdated.getIntitule());
        rAUpdate.setResume(reuUpdated.getResume());
        manager.flush();
        manager.getTransaction().commit();
        return reuUpdated;
    }
}
