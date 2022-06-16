package tp.web.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//ceci sert à configurer le milieu des URLs des WS REST
//url : http://locahost:8080/jeeAppWeb/api-user/user/1

//@ApplicationPath("/rest")
@ApplicationPath("/api-user")
public class MyRestApplicationConfig extends Application {

}
