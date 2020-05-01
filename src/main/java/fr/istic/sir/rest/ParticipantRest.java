package fr.istic.sir.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dao.daoParticipant;
import fr.istic.sir.rest.api.ParticipantApi;
import jpa.Participant;

import java.util.List;

@Path("/participants")
public class ParticipantRest implements ParticipantApi {

	private daoParticipant daoParticipant;

	public ParticipantRest() {
		this.daoParticipant = new daoParticipant();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Participant> getAllPart() {
		return daoParticipant.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Participant findById(@PathParam("id") long id) {
		return daoParticipant.findById(id);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public String deleteParticipant(@PathParam("id") long id) {
		daoParticipant.findById(id);
		return "Participant supprimé";
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public String updateParticipant(@PathParam("id") long id) {
		daoParticipant.findById(id);
		return "Participant mis à jour";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Participant createParticipant(Participant participant) {
		return daoParticipant.createParticipant(participant);
	}
}
