package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Participant {
	
	private String nom;
	
	private String prenom;

	@Id
	private String email;

	@ManyToMany
	private List<Sondage> sondagesParticipes = new ArrayList<Sondage>();

	public Participant() {}

	public Participant(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Sondage> getSondagesParticipes() {
		return sondagesParticipes;
	}

	public void setSondagesParticipes(List<Sondage> sondagesParticipes) {
		this.sondagesParticipes = sondagesParticipes;
	}

	public void addSondagesParticipes(Sondage sondageParticipe) {
		sondagesParticipes.add(sondageParticipe);
	}

}
