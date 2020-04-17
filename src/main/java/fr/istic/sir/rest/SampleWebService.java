package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.daoParticipant;
import dao.daoSondage;
import jpa.Participant;
import jpa.Sondage;

import java.util.List;

@Path("/hello")
public class SampleWebService {

	private daoSondage daoSondage;
	private daoParticipant daoParticipant;

	public SampleWebService() {
		this.daoSondage = new daoSondage();
		this.daoParticipant = new daoParticipant();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() { 
		return "Hello, how are you ? sir";
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sondage> listeSondages() {
		return daoSondage.listSondages();
	}

	@GET
	@Path("/createPart")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Participant> createPart() {
		Participant saly = new Participant("Knab", "Saly", "sk@ad.fr");
		Participant maud = new Participant("Garcon", "Maud", "mg@ad.fr");
		daoParticipant.createParticipant(saly);
		daoParticipant.createParticipant(maud);
		return daoParticipant.listParticipant();
	}
}
