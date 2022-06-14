package tp.mbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
//@RequestScoped
@SessionScoped
public class LoginBean {
	
	private String username;
	private String password;
	
	private void demoInutileJusteLienAvecApiServlet() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				   .getExternalContext().getSession(true);
		session.setAttribute("clef", "valeur");
		
		String strUsername = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("loginForm:username");
		System.out.println("username:" + strUsername);
	}
	
	
	
	public String connexion() {
		String suite = null;
		demoInutileJusteLienAvecApiServlet();
		if(password.equals("pwd"+username)) {
			suite="user";
		}else {
			FacesContext.getCurrentInstance().addMessage(null/*global*/,
			  new FacesMessage("invalid username or password",
					           "detail eventuel"));
		}
		return suite;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
