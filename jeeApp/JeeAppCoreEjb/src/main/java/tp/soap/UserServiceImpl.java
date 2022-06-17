package tp.soap;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import tp.dao.DaoUser;
import tp.dto.UserDto;
import tp.entity.User;

@Stateless
@Local
@WebService(endpointInterface = "tp.soap.UserService")
public class UserServiceImpl implements UserService {
	
	@Inject //ou bien @EJB
	private DaoUser daoUser;

	@Override
	public List<UserDto> fetchUsers() {
		List<User> usersEntities =  daoUser.getAllUser();
		List<UserDto> listeDto = new ArrayList<UserDto>();
		for(User userEntity : usersEntities) {
			UserDto uDto = new UserDto(userEntity.getId() , 
			           userEntity.getUsername() ,
			           userEntity.getPassword(),
			           userEntity.getEmail());
			listeDto.add(uDto);
		}
		return listeDto;
	}

	@Override
	public UserDto userById(Integer userId) {
		User userEntity = daoUser.getUserById(userId);
		return new UserDto(userEntity.getId() , 
				           userEntity.getUsername() ,
				           userEntity.getPassword(),
				           userEntity.getEmail());
	}

}
