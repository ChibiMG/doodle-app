package fr.istic.sir.rest;

import dao.daoSondage;
import jpa.Sondage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
