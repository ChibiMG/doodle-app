package dao;

import jpa.*;

import javax.persistence.EntityManager;

import java.util.List;

public class daoSondage {

    private EntityManager manager = EntityManagerHelper.getEntityManager();


    public List<Sondage> getAll() {
        List<Sondage> sondages = manager.createQuery("Select a From Sondage a", Sondage.class).getResultList();

        for (Sondage s : sondages){
            System.out.println(s.getCreateur().getNom() +" "
                    + s.getCreateur().getNom() + ", email : "
                    + s.getCreateur().getEmail() +", réunion : "
                    + s.getReunion() + ", date dispo : "
                    + s.getDates());
        }

        return sondages;
    }

    public Sondage createSondage(Sondage sondage) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(sondage);
        EntityManagerHelper.commit();
        return sondage;
    }

    public void deleteSondage(Long id) {
        Sondage survey = manager.find(Sondage.class,id);
        EntityManagerHelper.beginTransaction();
        manager.remove(survey);
        EntityManagerHelper.commit();
    }

    public Sondage updateSondage(Sondage sondage, Long currentId){
        Sondage survey = manager.find(Sondage.class,currentId);
        Long newCreateurId = sondage.getCreateur().getId();
        //pour modifier ses sondages
        Participant participant = manager.find(Participant.class, newCreateurId);

        manager.getTransaction().begin();
        survey.setReunion(sondage.getReunion());
        survey.setCreateur(sondage.getCreateur());
        survey.setDates(sondage.getDates());
        survey.setParticipants(sondage.getParticipants());
        survey.setReponses(sondage.getReponses());
        participant.addSondagesCrees(sondage);
        manager.getTransaction().commit();
        // à ajouter (?) supprimer le sondage ds la liste de sondage crees, de l'ancien createur de sondage
        return sondage;
    }

}
