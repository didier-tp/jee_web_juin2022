<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>visuCaddy</title>
</head>
<body>
     <%@ include file="entete.jsp" %>
   <h1>visuCaddy</h1>
   
   <c:if test="${caddy != null}"> 
	   <table border="2">
	      <c:forEach items="${caddy}" var="element">
	    		 <tr><td>${element}</td></tr> 
	     </c:forEach>
	   </table>
   </c:if>
   <p><a href="index.html">retour index</a></p>
   <p>Num de session (HttpSession java) : <%=session.getId() %></p>
</body>
</html>