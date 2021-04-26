package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.BoardDao;
import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/api/board")
@Produces({ "application/json" })
public class BoardResource {

	BoardDao daoB = new BoardDao();

	@GET
	@Path("/{id}")
	public Board getUserByMail(@PathParam("id") int id) {
		return daoB.getBoardById((long) id);
	}
	
	@GET
	@Path("/all")
	public List<Board> getAll() {
		return daoB.findAll();
	}

	@POST
	@Consumes("application/json")
	@Path("/createBoard")
	public Response addUser(@Parameter(description = "add Board", required = true) Board board) {
		daoB.save(board);
		return Response.ok().entity("SUCCESS").build();

	}

}
