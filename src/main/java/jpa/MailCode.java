package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MailCode {
	
	private Long id;
	
	private String code;
	
	private String lienPad;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLienPad() {
		return lienPad;
	}

	public void setLienPad(String lienPad) {
		this.lienPad = lienPad;
	}

}
