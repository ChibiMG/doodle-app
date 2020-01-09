package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sondage {
	
	private Long id;
	
	private Reunion reunion;
	
	private List<Date> dates = new ArrayList<Date>();
	
	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	private List<Participant> participants;

	public Sondage() {
		super();
	}

	public Sondage(Reunion reunion) {
		super();
		participants = new ArrayList<Participant>();
		this.reunion = reunion;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(mappedBy = "sondage",cascade = CascadeType.PERSIST)
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	@OneToMany
	public List<Date> getDates() {
		return dates;
	}

	public void addDates(Date date) {
		dates.add(date);
	}

	@ManyToMany(mappedBy = "sondagesParticipes")
	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public void addParticipants(Participant participant) {
		participants.add(participant);
	}

}
