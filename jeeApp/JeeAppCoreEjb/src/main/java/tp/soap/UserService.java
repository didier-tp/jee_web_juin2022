package tp.soap;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import tp.entity.User;

@WebService
public interface UserService {
    List<User> fetchUsers(); //ou mieux encore  List<UserDto>
    User userById(@WebParam(name="userId")Integer userId);
}
