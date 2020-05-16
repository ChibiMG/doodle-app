package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Sondage {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Reunion reunion;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Date> dates;

	@ManyToOne
	private Participant createur;

	public Sondage() {
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
	}

	public List<Date> getDates() {
		return dates;
	}

	public void addDate(Date date) {
		dates.add(date);
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
