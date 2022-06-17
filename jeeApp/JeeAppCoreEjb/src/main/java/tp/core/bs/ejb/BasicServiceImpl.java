package tp.core.bs.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

import tp.core.bs.BasicService;

//http://localhost:8080/JeeAppCoreEjb/UserServiceImpl?wsdl
//ou bien
//http://localhost:9080/JeeAppCoreEjb/UserServiceImpl?wsdl

@Stateless
@Local
public class BasicServiceImpl implements BasicService {

	@Override
	public String sayHello(String username) {
		return "Hello " + username;
	}

}
