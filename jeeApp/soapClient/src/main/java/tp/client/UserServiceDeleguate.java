package tp.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import tp.dto.UserDto;
import tp.soap.UserService;

public class UserServiceDeleguate implements UserService{
	
	private UserService userWSProxy ;
	
	public UserServiceDeleguate() {
				// appuserWSProxyeler un WS Soap codé en java (dans le même langage)
				// on peut se passer de wsimport.
				//NB: ce code ne fonctionne que si l'interface UserService comporte l'annotation @WebService

		
		        //NB: valeurs des QName dans ?wsdl
				QName SERVICE_NAME = new QName("http://soap.tp/", "UserServiceImplService");
				QName PORT_NAME = new QName("http://soap.tp/", "UserServiceImplPort");
				// en précisant une URL WSDL connue et accessible
				
				String wdlUrl =
				"http://localhost:8080/JeeAppCoreEjb/UserServiceImpl?wsdl";
				URL wsdlDocumentLocation=null;
				try {wsdlDocumentLocation = new URL(wdlUrl);
				} catch (MalformedURLException e) { e.printStackTrace();}
				
				//avec import javax.xml.ws.Service;
				Service service = Service.create(wsdlDocumentLocation, SERVICE_NAME);
				this.userWSProxy = (UserService)
				                service.getPort(PORT_NAME, UserService.class);
	}

	@Override
	public List<UserDto> fetchUsers() {
		return userWSProxy.fetchUsers();
	}

	@Override
	public UserDto userById(Integer userId) {
		return userWSProxy.userById(userId);
	}

	
}
