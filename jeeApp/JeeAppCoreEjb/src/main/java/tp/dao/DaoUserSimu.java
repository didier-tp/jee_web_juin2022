package tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;

import tp.entity.User;

@Local
@Stateless
public class DaoUserSimu implements DaoUser {
	
	private Map<Integer,User> mapUsers = new HashMap<>();
	private int maxId ;
	
	public DaoUserSimu(){
	   mapUsers.put(1,new User(1,"toto","pwdtoto","toto@xyz.fr"));
	   mapUsers.put(2,new User(2,"titi","pwdtiti","titi@xyz.fr"));
	   maxId=2;
	}

	@Override
	public User getUserById(Integer id) {
		return mapUsers.get(id);
	}

	@Override
	public List<User> getAllUser() {
		return new ArrayList<User>(mapUsers.values());
	}

	@Override
	public User saveUser(User u) {
		u.setId(++maxId); //simuler auto incrementation
		mapUsers.put(u.getId(),u);
		return u;//on retourne le user avec id connu/auto_incrémenté
	}

}
