package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({"application/json"})
public class UserResource{

	UserDao daoU = new UserDao();
	
	@GET
	@Path("/{mail}")
	public User getUserByMail(@PathParam("mail") String email) {
		return daoU.getUserByMail(email);
	}

	@POST
	@Consumes("application/json")
	public Response addUser(@Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
		// add pet
		return Response.ok().entity("SUCCESS").build();
	}
}