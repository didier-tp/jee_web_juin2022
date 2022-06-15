<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
      <%@ include file="entete.jsp" %>
	<form method="POST"
		action='<%=response.encodeURL("j_security_check")%>'>
	
		<label>Username:</label> <input type="text" name="j_username"><br/>
		
		<label>Password:</label><input type="password" name="j_password"><br/>
		
		<input type="submit" value="Log In">
	</form>
</body>
</html>