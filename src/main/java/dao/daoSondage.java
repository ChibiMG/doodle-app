package dao;

import jpa.*;

import javax.persistence.EntityManager;

import java.util.List;

public class daoSondage {

    private EntityManager manager = EntityManagerHelper.getEntityManager();


    public List<Sondage> getAll() {
         return manager.createQuery("Select a From Sondage a", Sondage.class).getResultList();
    }

    public Sondage createSondage(Sondage sondage) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(sondage);
        EntityManagerHelper.commit();
        return sondage;
    }


}
