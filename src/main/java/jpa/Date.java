package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Date {

	@Id
	private String date;

	@OneToMany(mappedBy = "date")
	private List<Reponse> reponses;

	@ManyToOne
	private Sondage sondage;
	
	public Date() {
		super();
	}

	public Date(String date) {
		super();
		this.date = date;
		reponses = new ArrayList<Reponse>();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public void addReponse(Reponse reponse) {
		reponses.add(reponse);
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
}
