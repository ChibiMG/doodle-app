package jpa;

import java.util.List;

public class Sondage {
	
	private Reunion reunion;
	
	private List<Date> dates;
	
	private List<Participant> participants;
	
	private List<Sondage> sondagesCrees;
	
	private List<Sondage> sondagesParticipes;

	public List<Sondage> getSondagesCrees() {
		return sondagesCrees;
	}

	public void setSondagesCrees(List<Sondage> sondagesCrees) {
		this.sondagesCrees = sondagesCrees;
	}

	public List<Sondage> getSondagesParticipes() {
		return sondagesParticipes;
	}

	public void setSondagesParticipes(List<Sondage> sondagesParticipes) {
		this.sondagesParticipes = sondagesParticipes;
	}

	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}
