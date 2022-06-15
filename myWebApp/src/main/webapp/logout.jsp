<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login_logout</title>
</head>
<body>
     sessionId=<%=session.getId()%>
     <hr/>
     <a href="MvcServlet?tache=logout">logout (invalidate security_context or/and session)</a>
   
</body>
</html>