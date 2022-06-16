package tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`USER`")
public class User {
	
   @Id	
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   private String username;
   
   //@Column(name="password" , length = 64)
   private String password;
   
   private String email;
   
   
   
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
}

public User() {
	super();
}

public User(Integer id, String username, String password, String email) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.email = email;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
   
   
}
