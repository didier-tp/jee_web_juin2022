package tp.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tp.dao.DaoUser;
import tp.entity.User;

@Path("/user")
@Produces("application/json")
public class CtrlRestUser {
	
	@Inject
	private DaoUser daoUser; //déléguation vers EJB implémentant interface DaoUser
	
	@GET
	@Path("/{id}")
	//url = http://localhost:8080/jeeAppWeb/api-user/user/1
	public User getUserById(@PathParam("id") Integer id) {
		return daoUser.getUserById(id);
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
