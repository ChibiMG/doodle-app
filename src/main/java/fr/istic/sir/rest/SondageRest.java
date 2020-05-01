package fr.istic.sir.rest;

import dao.daoSondage;
import jpa.Sondage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/survey")
public class SondageRest {

    private daoSondage daoSondage;

    public SondageRest() {
        this.daoSondage = new daoSondage();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sondage> getAll() {
        return daoSondage.getAll();
    }

    @POST
    @Path("/createParticipant")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sondage createParticipant(Sondage sondage) {
        return daoSondage.createSondage(sondage);
    }

    @DELETE
    @Path("/deleteSondage/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteSondage(@PathParam("id") long id) {
        daoSondage.deleteSondage(id);
        return "Participant supprimé";
    }

//    @PUT
//    @Path("/updateSondage/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Override
//    public String updateParticipant(Sondage sondage, @PathParam("id") long id) {
//        daoSondage.updateSondage(sondage, id);
//        return "Sondage mis à jour";
//    }
}
