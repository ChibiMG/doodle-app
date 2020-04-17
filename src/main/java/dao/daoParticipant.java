package dao;

import jpa.EntityManagerHelper;
import jpa.Participant;

import javax.persistence.EntityManager;
import java.util.List;

public class daoParticipant {
    private EntityManager manager = EntityManagerHelper.getEntityManager();

    public List<Participant> listParticipant() {
        return manager.createQuery("Select p From Participant p", Participant.class).getResultList();
    }

    public Participant createParticipant(Participant part) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(part);
        EntityManagerHelper.commit();
        return part;
    }
}
