package dao;

import jpa.EntityManagerHelper;
import jpa.Sondage;
import javax.persistence.EntityManager;

import java.util.List;

public class daoSondage {

    private EntityManager manager = EntityManagerHelper.getEntityManager();

    private List<Sondage> listSondages() {
         return manager.createQuery("Select a From Sondage a", Sondage.class).getResultList();
    }

}
