package tp.client;

import tp.dto.UserDto;
import tp.soap.UserService;

public class SoapClientApp {

	public static void main(String[] args) {
		
		UserService ws = new UserServiceDeleguate();
		
		UserDto uDto = ws.userById(1);
		System.out.println("SoapClientApp (dyn , sans wsimport)\n********");
		System.out.println("uDto="+uDto);
	
	}

}
