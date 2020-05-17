package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Date {

	@Id
	@GeneratedValue
	private long id;

	private String date;

	@OneToMany(mappedBy = "date", orphanRemoval = true)
	private List<Reponse> reponses;
	
	public Date() {}

	public Date(String date) {
		this.date = date;
		reponses = new ArrayList<Reponse>();
	}

	public long getId() {
		return id;
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

}
