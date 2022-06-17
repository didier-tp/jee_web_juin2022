package tp.soap;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import tp.dao.DaoUser;
import tp.entity.User;

@Stateless
@Local
@WebService(endpointInterface = "tp.soap.UserService")
public class UserServiceImpl implements UserService {
	
	@Inject //ou bien @EJB
	private DaoUser daoUser;

	@Override
	public List<User> fetchUsers() {
		List<User> usersEntities =  daoUser.getAllUser(); 
		return usersEntities;//tp rapide 
	}

	@Override
	public User userById(Integer userId) {
		User userEntity = daoUser.getUserById(userId);
		return userEntity; //tp rapide
		//return new UserDto(userEntity.getId() , userEntity.getUsername() , ...);
	}

}
