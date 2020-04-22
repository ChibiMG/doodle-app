package fr.istic.sir.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dao.DaoParticipant;
import dao.DaoSondage;
import jpa.Participant;
import jpa.Sondage;

import java.util.List;

@Path("/hello")
public class SampleWebService {

	private DaoSondage daoSondage;
	private DaoParticipant daoParticipant;

	public SampleWebService() {
		this.daoSondage = new DaoSondage();
		this.daoParticipant = new DaoParticipant();
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
		return daoSondage.getAll();
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
