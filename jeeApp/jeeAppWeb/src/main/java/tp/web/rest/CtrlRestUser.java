package tp.web.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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

}
