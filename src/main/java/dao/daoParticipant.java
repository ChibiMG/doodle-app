package dao;

import jpa.EntityManagerHelper;
import jpa.Participant;

import javax.persistence.EntityManager;
import java.util.List;

public class daoParticipant {
    private EntityManager manager = EntityManagerHelper.getEntityManager();

    public List<Participant> getAll() {

        List<Participant> participants = manager.createQuery("Select p From Participant p", Participant.class).getResultList();

        for (Participant p : participants){
            System.out.println(p.getPrenom() +" "+ p.getNom() + ", email : "+ p.getEmail());
        }
        return participants;
    }

    public Participant createParticipant(Participant part) {
        EntityManagerHelper.beginTransaction();
        manager.persist(part);
        EntityManagerHelper.commit();
        return part;
    }

    public Participant findById(Long id){
        return manager.createQuery("Select p From Participant p where p.id = :id", Participant.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void deleteParticipant(Participant part) {
        EntityManagerHelper.beginTransaction();
        manager.remove(part);
        EntityManagerHelper.commit();
    }

    public Participant updateParticipant(Participant part, Long currentId){
        Participant participant = manager.find(Participant.class,currentId);
        manager.getTransaction().begin();
        participant.setNom(part.getNom());
        participant.setPrenom(part.getPrenom());
        participant.setEmail(part.getEmail());
        manager.getTransaction().commit();
        return part;
    }
}
