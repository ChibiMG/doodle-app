package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.daoSondage;
import jpa.Sondage;

import java.awt.*;
import java.util.List;

@Path("/hello") 
public class SampleWebService {

//	private dao.daoSondage daoSondage;
//
//	public SampleWebService() {
//		this.daoSondage = new daoSondage();
//	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() { 
		return "Hello, how are you ? sir";
	}

	@GET
	@Path("/home")
	@Produces(MediaType.TEXT_PLAIN)
	public String findAll() {
		return "hi";
	}
	

}
