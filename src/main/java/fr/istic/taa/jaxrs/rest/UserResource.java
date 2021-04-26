package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/api/user")
@Produces({ "application/json" })
public class UserResource {

	UserDao daoU = new UserDao();

	@GET
	@Path("/{mail}")
	public User getUserByMail(@PathParam("mail") String email) {
		return daoU.getUserByMail(email);
	}

	@POST
	@Consumes("application/json")
	@Path("/addUser")
	// si on veut rajouter une nouvelle classe en param il faut faire un nouveau
	// @param
	public Response addUser(@Parameter(description = "add user", required = true) User user) {
		// java va comprendre grace au JSON envoyée dans la requette de quelle objet on
		// parle
		daoU.save(user);
		return Response.ok().entity("SUCCESS").build();
	}
}