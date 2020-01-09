package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MailPause {

	private String lienAlimentation;
	
	@Id
	public String getLienAlimentation() {
		return lienAlimentation;
	}

	public void setLienAlimentation(String lienAlimentation) {
		this.lienAlimentation = lienAlimentation;
	}
	
}
