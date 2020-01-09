package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reunion {
	
	private Long id;
	
	private String intitule;
	
	private String resume;
	
	private Date dateReunion;
	
	private Sondage sondage;
	
	public Reunion() {
		super();
	}

	public Reunion(String intitule, String resume) {
		super();
		this.intitule = intitule;
		this.resume = resume;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	@OneToOne
	public Date getDateReunion() {
		return dateReunion;
	}

	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@OneToOne
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

}
