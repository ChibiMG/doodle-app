package fr.istic.sir.rest;

import dao.DaoParticipant;
import jpa.Participant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/participants")
public class ParticipantRest {

	private DaoParticipant daoParticipant;

	public ParticipantRest() {
		this.daoParticipant = new DaoParticipant();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Participant> getAllPart() {
		return daoParticipant.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Participant findById(@PathParam("id") String email) {
		return daoParticipant.findById(email);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteParticipant(@PathParam("id") String email) {
		Participant aDelete = daoParticipant.findById(email);
		daoParticipant.deleteParticipant(aDelete);
		return "Participant supprimé";
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Participant updateParticipant(@PathParam("id") String id, Participant pUpdate) {
		return daoParticipant.updateParticipant(id, pUpdate);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Participant createParticipant(Participant participant) {
		return daoParticipant.createParticipant(participant);
	}
}