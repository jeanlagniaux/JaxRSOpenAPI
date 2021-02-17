package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.BoardDao;
import fr.istic.taa.jaxrs.domain.Pet;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/board")
@Produces({ "application/json"})
public class BoardResource {

	BoardDao daoB = new BoardDao();
	
//	@GET
//	@Path("/{id}")
//	public List<User> getAffectedUser() {
//		return daoB;
//	}

	@POST
	@Consumes("application/json")
	public Response addBoard(@Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
		// add pet
		return Response.ok().entity("SUCCESS").build();
	}
	
}
