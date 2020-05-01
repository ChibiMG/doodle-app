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
        try {
            EntityManagerHelper.beginTransaction();
            manager.persist(part);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return part;
    }

    public Participant findById(String email){
        return manager.createQuery("Select p From Participant p where p.email = :email", Participant.class)
                .setParameter("email", email)
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
