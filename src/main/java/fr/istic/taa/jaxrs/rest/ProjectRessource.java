package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.ProjectDao;
import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Project;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/projet")
@Produces({ "application/json" })
public class ProjectRessource {

	public class BoardResource {

		ProjectDao daoP = new ProjectDao();

		@GET
		@Path("/{name}")
		public List<Board> getBoardsByProjectName(@PathParam("name") String name) {
			return daoP.getBoardsByProjectName(name);
		}

		@POST
		@Consumes("application/json")
		@Path("/createProject")
		public Response addProject(@Parameter(description = "add project", required = true) Project project) {
			daoP.save(project);
			return Response.ok().entity("SUCCESS").build();

		}

	}

}
