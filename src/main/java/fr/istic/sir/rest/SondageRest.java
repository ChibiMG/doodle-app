package fr.istic.sir.rest;

import dao.DaoSondage;
import jpa.Sondage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/sondages")
public class SondageRest {

    private DaoSondage daoSondage;

    public SondageRest() {
        this.daoSondage = new DaoSondage();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sondage> getAll() {
        return daoSondage.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sondage createSondage(Sondage sondage) {
        return daoSondage.createSondage(sondage);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sondage findByIdSondage(@PathParam("id") Long id) {
        return daoSondage.getSondageById(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteSondage(@PathParam("id") long id) {
        Sondage aDelete = daoSondage.getSondageById(id);
        daoSondage.deleteSondage(aDelete);
        return "Sondage supprimé";
    }

    @PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Sondage updateSondage(@PathParam("id") Long id, Sondage sUpdate) {
		return daoSondage.updateSondage(id, sUpdate);
	}
}
