package tp.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tp.entity.User;

//@Local
//@Stateless
public class DaoUserJpa implements DaoUser {
	
	//@PersistenceContext(unitName = "JeeAppCoreEjb")
	private EntityManager entityManager;

	@Override
	public User getUserById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getAllUser() {
		return entityManager.createQuery("SELECT u FROM User u",User.class)
				            .getResultList();
	}

}
