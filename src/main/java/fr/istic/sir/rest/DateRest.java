package fr.istic.sir.rest;

import dao.DaoDate;
import jpa.Date;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/sondages/{id}/dates")
public class DateRest {

	private DaoDate daoDate;

	public DateRest() {
		this.daoDate = new DaoDate();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Date createDate(Date date) {
		return daoDate.createDate(date);
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Date> getAll(@PathParam("id") Long id) {
        return daoDate.getDatesForSondageId(id);
    }
}