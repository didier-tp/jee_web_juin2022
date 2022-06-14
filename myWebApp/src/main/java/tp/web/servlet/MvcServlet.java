package tp.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.web.model.CalculTva;

/**
 * Servlet implementation class MvcServlet
 */
@WebServlet("/MvcServlet")
public class MvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MvcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tache = request.getParameter("tache"); //tache vaudra "calculTva" ou "recherherPersonne"
	    switch(tache) {
	    case "calculTva":
	    	doCalculTva(request,response);
	    	break;
	    //...	
	    }
	}
	
	protected void doCalculTva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      CalculTva calculTva = new CalculTva();
	      calculTva.setHt(request.getParameter("ht"));
	      calculTva.setTauxTva(request.getParameter("taux_tva"));
	      String pathJsp ; 
	      try {
			calculTva.calculer();
			pathJsp = "/resCalculTva.jsp";//redirection vers page resultat quand ok
		  } catch (RuntimeException e) {
			pathJsp = "/saisirCalculTva.jsp";//redirection vers page erreur
			                                 //ou bien page de meilleur saisie
		  }
	      RequestDispatcher rd = this.getServletContext().getRequestDispatcher(pathJsp);
	      //HttpSession session = request.getSession();
	      //session.setAttribute("calculTva", calculTva);
	      request.setAttribute("calculTva", calculTva);//on stocke dans l'objet request
	                                                   //un accès à l'objet "calculTva"
	      												//pour que la page jsp puisse y accéder
	      rd.forward(request, response); //redirection vers page JSP (jouant le rôle de VUE dans MVC)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
