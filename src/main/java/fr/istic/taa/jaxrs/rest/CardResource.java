package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.CardDao;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/card")
@Produces({ "application/json"})
public class CardResource {

	CardDao daoC = new CardDao();
	
	@GET
	@Path("/{id}")
	public List<User> getAffectedUser() {
		return daoC.getAffectedUser();
	}

	@POST
	@Consumes("application/json")
	public Response addCard(@Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
		// add pet
		return Response.ok().entity("SUCCESS").build();
	}
	
	
}
