package fr.istic.sir.rest.api;

import jpa.Participant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface ParticipantApi {

    @GET
    //@Path("/allParticipant")
    @Produces(MediaType.APPLICATION_JSON)
    List<Participant> getAllPart();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Participant findById(@PathParam("id") long id);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    String deleteParticipant(@PathParam("id") long id);

    @POST
    @Path("/createParticipant")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Participant createParticipant(Participant participant);
}
