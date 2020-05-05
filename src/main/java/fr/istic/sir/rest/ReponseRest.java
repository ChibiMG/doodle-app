package fr.istic.sir.rest;

import dao.DaoReponse;
import jpa.Reponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/reponses")
public class ReponseRest {

    private DaoReponse daoReponse;

    public ReponseRest(){this.daoReponse = new DaoReponse();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reponse> getAll() {
        return daoReponse.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reponse createReponse(Reponse reponse) {
        return daoReponse.createReponse(reponse);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reponse findByIdRep(@PathParam("id") Long id) {
        return daoReponse.getReponseById(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteReponse(@PathParam("id") long id) {
        Reponse aDelete = daoReponse.getReponseById(id);
        daoReponse.deleteReponse(aDelete);
        return "Réponse supprimée";
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reponse updateReponse(@PathParam("id") Long id, Reponse newReponse) {
        return daoReponse.updateReponse(id, newReponse);
    }
}
