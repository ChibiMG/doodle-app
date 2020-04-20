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
}
