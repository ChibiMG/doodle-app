package jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reunion {

	@Id
	@GeneratedValue
	private Long id;

	private String intitule;

	private String resume;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Date dateReunion;

	public Reunion() {
	}

	public Reunion(String intitule, String resume) {
		this.intitule = intitule;
		this.resume = resume;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


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

}