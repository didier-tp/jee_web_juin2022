package tp.dao;

import java.util.List;

import tp.entity.User;

/*
 * interface DaoUser pour DAO = Data Access Object
 * avec méthode CRUD
 */

public interface DaoUser {
     User getUserById(Integer id);
     List<User> getAllUser();
     //...
}
