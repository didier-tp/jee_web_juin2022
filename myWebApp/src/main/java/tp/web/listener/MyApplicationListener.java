package tp.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyApplicationListener
 *
 */
@WebListener
public class MyApplicationListener implements ServletContextListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	ServletContext application = sre.getServletContext();
    	Integer compteur = (Integer) application.getAttribute("compteur");
    	if(compteur !=null) compteur = compteur + 1; else compteur = 1;
    	application.setAttribute("compteur", compteur);
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	 ServletContext application = sce.getServletContext();
         System.out.println("compteur=" +application.getAttribute("compteur"));
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext application = sce.getServletContext();
         application.setAttribute("compteur", 0);
    }
	
}

/*
dans tomcat/conf/tomcat-users.xml

<role rolename="manager-gui"/>
  <role rolename="tomcat"/>
  <role rolename="role1"/>
  <user username="tomcat" password="tomcat" roles="tomcat,manager-gui"/>
  
on peut accéder à une console d'admin de tomcat
localhost:8080/manager   (username="tomcat" password="tomcat")
*/
