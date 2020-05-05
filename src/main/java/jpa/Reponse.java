package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reponse {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Participant participant;

    @ManyToOne
    private Date date;

    @ManyToOne
    private Sondage sondage;

    public Reponse() {}

    public Reponse(Participant participant, Date date, Sondage sondage){
        this.participant = participant;
        this.date = date;
        this.sondage = sondage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}