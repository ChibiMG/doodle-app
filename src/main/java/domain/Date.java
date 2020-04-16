package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Date {
	
	private String date;
	
	private boolean pause;
	
	public Date() {
		super();
	}

	public Date(String date, boolean pause) {
		super();
		this.date = date;
		this.pause = pause;
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
