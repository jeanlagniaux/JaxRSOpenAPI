package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.CardDao;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/card")
@Produces({ "application/json" })
public class CardResource {

	CardDao daoC = new CardDao();

	@GET
	@Path("/{id}/users")
	public List<User> getAffectedUser(@PathParam("id") int id) {
		return daoC.getCardUsersById((long) id);
	}

	@GET
	@Path("/{id}")
	public Card getCardById(@PathParam("id") int id) {
		return daoC.getCardById((long) id);
	}

	@POST
	@Consumes("application/json")
	@Path("/addCard")
	// si on veut rajouter une nouvelle classe en param il faut faire un nouveau
	// @param
	public Response addCard(@Parameter(description = "add user", required = true) Card card) {
		// java va comprendre grace au JSON envoy�e dans la requette de quelle objet on
		// parle
		daoC.save(card);
		return Response.ok().entity("SUCCESS").build();
	}

}
