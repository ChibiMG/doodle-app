package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Sondage {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "sondage", cascade = CascadeType.PERSIST)
	private Reunion reunion;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Date> dates;

	@ManyToMany(mappedBy = "sondagesParticipes")
	private List<Participant> participants;

	@ManyToOne
	private Participant createur;

	public Sondage() {
		participants = new ArrayList<Participant>();
		dates = new ArrayList<Date>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
		reunion.setSondage(this);
	}

	public List<Date> getDates() {
		return dates;
	}

	public void addDate(Date date) {
		dates.add(date);
	}

	public void addDates(List<Date> allDates) {
		dates.addAll(allDates);
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public void addParticipant(Participant participant) {
		participants.add(participant);
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	public Participant getCreateur() {
		return createur;
	}

	public void setCreateur(Participant createur) {
		this.createur = createur;
	}
}
