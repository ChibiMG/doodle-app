package fr.istic.sir.rest.api;

import jpa.Participant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Interface du participant
 */

public interface ParticipantApi {

    /**
     * @return tous les participants
     */
    @GET
    //@Path("/allParticipant")
    @Produces(MediaType.APPLICATION_JSON)
    List<Participant> getAllPart();

    /**
     *
     * @param id
     * @return le participant avec cet id
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Participant findById(@PathParam("id") long id);

    /**
     *
     * @param id
     * @return le message indiquant la suppression du participant
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    String deleteParticipant(@PathParam("id") long id);

    @GET
    @Path("/updateParticipant/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    String updateParticipant(Participant participant, @PathParam("id") long id);

    /**
     *
     * @param participant
     * @return le nouveau participant créé
     */
    @POST
    @Path("/createParticipant")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Participant createParticipant(Participant participant);
}
