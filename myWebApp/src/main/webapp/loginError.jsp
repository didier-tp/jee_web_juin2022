<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loginError</title>
</head>
<body>
  <%@ include file="entete.jsp" %>
<font color='red'>Invalid username and/or password</font> <hr/>
<form> <input value="try again" type="button" onclick="history.back();"/></form>
</body>
</html>