package tp.core.bs.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

import tp.core.bs.BasicService;

@Stateless
@Local
public class BasicServiceImpl implements BasicService {

	@Override
	public String sayHello(String username) {
		return "Hello " + username;
	}

}
