package tp.web.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tp.entity.User;

public class UserBean {
	private Integer id; //personne de l'utilisateur recherché
	private User user; //utilisateur trouvé en base
	//...
	
	private DataSource dataSource;
	
	private void  initDataSource(){
		String dsName = "java:comp/env/jdbc/myDB"; //avec "jdbc/myDB" dans web.xml
		// Nom logique JNDI
		// Obtention via JinitDataSource()NDI de l'objet DataSource:
		try {
			InitialContext ic = new InitialContext();
			this.dataSource = (DataSource) ic.lookup(dsName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void rechercherUserById() {
		if(this.dataSource==null) initDataSource();
		Connection cn = null;
		try {
			// Récupération de la connexion via le pool de connexions:
			cn = dataSource.getConnection();
			
			// … utilisation classique d’une connexion JDBC …
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM User WHERE ID="+this.id);
			if(rs.next()) {
				this.user = new User(rs.getInt("ID"),
						             rs.getString("username"),
						             rs.getString("password"),
						             rs.getString("email"));
			}
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close(); // fermeture (virtuelle) de la connexion
				//celle ci est libérée et replacée dans le pool.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
