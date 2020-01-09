package jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Participant {
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private List<Sondage> sondagesCrees;
	
	private List<Sondage> sondagesParticipes;

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

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToOne
	public List<Sondage> getSondagesCrees() {
		return sondagesCrees;
	}

	public void addSondagesCrees(Sondage sondageCree) {
		sondagesCrees.add(sondageCree);
	}

	@OneToOne
	public List<Sondage> getSondagesParticipes() {
		return sondagesParticipes;
	}

	public void addSondagesParticipes(Sondage sondageParticipe) {
		sondagesParticipes.add(sondageParticipe);
	}

}
