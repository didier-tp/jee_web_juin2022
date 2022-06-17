package tp.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tp.dao.DaoUser;
import tp.entity.User;

@Path("/user")
@Produces("application/json")
public class CtrlRestUser {
	
	@Inject
	private DaoUser daoUser; //déléguation vers EJB implémentant interface DaoUser
	
	/*
	@GET
	@Path("/{id}")
	//url = http://localhost:8080/jeeAppWeb/api-user/user/1
	public User getUserById(@PathParam("id") Integer id) {
		return daoUser.getUserById(id); //améliorable via DTO
	}*/
	
	
	@GET
	@Path("/{id}")
	//url = http://localhost:8080/jeeAppWeb/api-user/user/1
	public Response getUserById(@PathParam("id") Integer id) {
		User u = daoUser.getUserById(id); //améliorable via DTO
		if(u==null)
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.status(Status.OK)
			         .entity(u)
			         .build();
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	//url = http://localhost:8080/jeeAppWeb/api-user/user
	//avec { "id" : null , "username" : "user3" , "password" : "pwduser3" , "email" : "..." }
	public User postUser( User u) {
		return daoUser.saveUser(u); //améliorable via DTO
	}
	
	@GET
	@Path("")
	//url = http://localhost:8080/jeeAppWeb/api-user/user
	//url = http://localhost:8080/jeeAppWeb/api-user/user?username=toto
	public List<User> getUsersByCriteria(@QueryParam("username") String username) {
		List<User> listeUsers = daoUser.getAllUser();
		if(username==null) 
			return listeUsers;
		else 
			return listeUsers.stream()
				   .filter(u-> u.getUsername().equals(username))
				   .collect(Collectors.toList());
	}

}
