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
        Participant q = (Participant) manager.createQuery("Select p From Participant p where p.id = :id", Participant.class)
                .setParameter("id", id)
                .getResultList();
        return q ;
    }

    public Participant deleteParticipant(Participant part) {
        EntityManagerHelper.beginTransaction();
        manager.remove(part);
        EntityManagerHelper.commit();
        return part;
    }

//    public Participant updateParticipant(Participant part, Long currentId){
//        EntityManagerHelper.beginTransaction();
//        EntityManagerHelper.getEntityManager().persist(part);
//        EntityManagerHelper.commit();
//        return part;
//    } chercher à faire un update avec entitymanager
}
