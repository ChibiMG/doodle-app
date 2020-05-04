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

    public Reponse() {}
}