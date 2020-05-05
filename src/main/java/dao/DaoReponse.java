package dao;

import jpa.EntityManagerHelper;
import jpa.Reponse;
import jpa.Reunion;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoReponse {
    private EntityManager manager = EntityManagerHelper.getEntityManager();

    public List<Reponse> getAll() {
        return manager.createQuery("Select r From Reponse r", Reponse.class).getResultList();
    }

    public Reponse createReponse(Reponse reponse) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(reponse);
        EntityManagerHelper.commit();
        return reponse;
    }

    public Reponse getReponseById(Long id){
        return manager.createQuery("Select r From Reponse r where r.id= :id", Reponse.class).setParameter("id", id).getSingleResult();
    }
}
