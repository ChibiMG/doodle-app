package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Date {
	
	private String date;
	
	private boolean pause;
	
	public Date() {
		super();
	}

	public Date(String date) {
		super();
		this.date = date;
		this.pause = true;
	}

	@Id
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

}
