package fr.istic.sir.rest;

import dao.DaoReunion;
import jpa.Reunion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/reunions")
public class ReunionRest {

    private DaoReunion daoReunion;

    public ReunionRest(){this.daoReunion = new DaoReunion();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reunion> getAll() {
        return daoReunion.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reunion createReunion(Reunion reunion) {
        return daoReunion.createReunion(reunion);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reunion findByIdReu(@PathParam("id") Long id) {
        return daoReunion.getReunionById(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteReunion(@PathParam("id") long id) {
        Reunion aDelete = daoReunion.getReunionById(id);
        daoReunion.deleteReunion(aDelete);
        return "Réunion supprimée";
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reunion updateReunion(@PathParam("id") Long id, Reunion newReunion) {
        return daoReunion.updateReunion(id, newReunion);
    }
}
