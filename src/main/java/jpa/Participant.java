package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Participant {
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private List<Sondage> sondagesCrees= new ArrayList<Sondage>();
	
	private List<Sondage> sondagesParticipes = new ArrayList<Sondage>();

	public Participant() {}

	public Participant(String nom, String prenom, String email) {
		super();
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

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany
	@JoinColumn(name="createur")
	public List<Sondage> getSondagesCrees() {
		return sondagesCrees;
	}

	public void addSondagesCrees(Sondage sondageCree) {
		sondagesCrees.add(sondageCree);
	}

	@ManyToMany
	public List<Sondage> getSondagesParticipes() {
		return sondagesParticipes;
	}

	public void setSondagesCrees(List<Sondage> sondagesCrees) {
		this.sondagesCrees = sondagesCrees;
	}

	public void setSondagesParticipes(List<Sondage> sondagesParticipes) {
		this.sondagesParticipes = sondagesParticipes;
	}

	public void addSondagesParticipes(Sondage sondageParticipe) {
		sondagesParticipes.add(sondageParticipe);
	}

}
