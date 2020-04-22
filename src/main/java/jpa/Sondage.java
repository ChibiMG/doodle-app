package jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Sondage {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "sondage",cascade = CascadeType.PERSIST)
	private Reunion reunion;

	@OneToMany(mappedBy = "sondage")
	private List<Date> dates;

	@ManyToMany(mappedBy = "sondagesParticipes")
	private List<Participant> participants;

	@ManyToOne
	private Participant createur;

	public Sondage() {
		super();
		participants = new ArrayList<Participant>();
		dates = new ArrayList<Date>();
	}

	public Sondage(Reunion reunion, List<Date> dates, Participant createur) {
		super();
		participants = new ArrayList<Participant>();
		this.reunion = reunion;
		this.dates = dates;
		this.createur = createur;
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
	}

	public List<Date> getDates() {
		return dates;
	}

	public void addDate(Date date) {
		dates.add(date);
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