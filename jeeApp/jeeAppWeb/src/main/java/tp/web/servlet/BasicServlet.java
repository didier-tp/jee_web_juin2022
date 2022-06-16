package tp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.core.bs.BasicService;
import tp.dao.DaoUser;
import tp.entity.User;

/**
 * Servlet implementation class BasicServlet
 */
@WebServlet("/BasicServlet")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//@EJB // since JEE 5 (ok for EJB local or remote)
	@Inject //since JEE 6 (for local EJB only or CDI components)
	private BasicService basicService;//impl by ebj stateless
	
	@Inject
	private DaoUser daoUser;
	//via @Inject ou bien @EJB la référence daoUser va être initialisée par Jboss de manière
	//à se relier à un composant de l'application qui est compatible avec l'interface DaoUser
 
    public BasicServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		username=username!=null?username:"unknown";
		String message=basicService.sayHello(username);
		
		List<User> listeUsers = daoUser.getAllUser();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>BasicServlet</h3>");
		out.println("<p>username=<i>"+username+"</i></p>");
		out.println("<p>message=<b>"+message+"</b></p>");
		out.println("<p>listeUsers=<b>"+listeUsers.toString()+"</b></p>");
		out.println("<body><html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
