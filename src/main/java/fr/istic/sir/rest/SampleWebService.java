package fr.istic.sir.rest;

import javax.ws.rs.*;
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

	@POST
	@Path("/createParticipant")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Participant createParticipant(Participant participant) {
//		Participant saly = new Participant("Knab", "Saly", "sk@ad.fr");
//		Participant maud = new Participant("Garcon", "Maud", "mg@ad.fr");
		return daoParticipant.createParticipant(participant);
	}
}
