package fr.istic.sir.rest;

import dao.DaoDate;
import jpa.Date;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/dates")
public class DateRest {

	private DaoDate daoDate;

	public DateRest() {
		this.daoDate = new DaoDate();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Date> getAllPart() {
		return daoDate.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Date findById(@PathParam("id") String email) {
		return daoDate.findById(email);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteDate(@PathParam("id") String email) {
		Date aDelete = daoDate.findById(email);
		daoDate.deleteDate(aDelete);
		return "Date supprimée";
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Date updateDate(@PathParam("id") String id, Date pUpdate) {
		return daoDate.updateDate(id, pUpdate);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Date createDate(Date date) {
		return daoDate.createDate(date);
	}
}