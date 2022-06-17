package tp.soap;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import tp.dto.UserDto;

@WebService
public interface UserService {
    List<UserDto> fetchUsers(); 
    UserDto userById(@WebParam(name="userId")Integer userId);
}
