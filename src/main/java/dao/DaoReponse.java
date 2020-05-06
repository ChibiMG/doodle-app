package dao;

import jpa.EntityManagerHelper;
import jpa.Reponse;
import jpa.Sondage;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoReponse {

    private EntityManager manager = EntityManagerHelper.getEntityManager();


    public List<Reponse> getAll() {
        return manager.createQuery("Select r From Reponse r", Reponse.class).getResultList();
    }

    public Reponse createReponse(Reponse reponse) {
        EntityManagerHelper.beginTransaction();
        manager.persist(reponse);
        EntityManagerHelper.commit();
        return reponse;
    }


    public Reponse getReponseById(Long id){
        return manager.createQuery("Select r From Reponse r where r.id= :id", Reponse.class).setParameter("id", id).getSingleResult();
    }

    public List<Reponse> getReponseBySondageId(Sondage sondage){
        return manager.createQuery("Select r From Reponse r where r.sondage= :sondage", Reponse.class).setParameter("sondage", sondage).getResultList();
    }

    public void deleteReponse(Reponse reponse) {
        EntityManagerHelper.beginTransaction();
        manager.remove(reponse);
        EntityManagerHelper.commit();
    }

    public Reponse updateReponse(Long id, Reponse reponseUpdated){
        manager.getTransaction().begin();
        Reponse rAUpdate = manager.find(Reponse.class,id);
        rAUpdate.setDate(reponseUpdated.getDate());
        //Pas besoin de mettre participant car ce sera le même à chaque fois (?) Il ne change donc pas
        //rAUpdate.setParticipant(reponseUpdated.getParticipant());
        manager.flush();
        manager.getTransaction().commit();
        return reponseUpdated;
    }
}
