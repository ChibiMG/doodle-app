package jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Sondage {
	
	private Long id;
	
	private Reunion reunion;
	
	private List<Date> dates;
	
	private List<Participant> participants;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@OneToOne
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	@OneToOne
	public List<Date> getDates() {
		return dates;
	}

	public void addDates(Date date) {
		dates.add(date);
	}

	@ManyToOne
	public List<Participant> getParticipants() {
		return participants;
	}

	public void addParticipants(Participant participant) {
		participants.add(participant);
	}

}
