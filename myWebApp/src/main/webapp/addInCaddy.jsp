<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addInCaddy</title>
</head>
<body>
   <%
   String produit = request.getParameter("produit");
   String message="";
   if(produit != null){
	   List caddy = (List) session.getAttribute("caddy");
	   if(caddy == null){
		   caddy = new java.util.ArrayList<String>();
		   session.setAttribute("caddy",caddy);
	   }
	   caddy.add(produit);
	   message="l'element " + produit +
			   " vient d'etre ajouté dans le caddy en session ; taille du caddy = " + caddy.size();
   }
   %>

   <h1>visuCaddy.jsp</h1>
   <form> 
      produit : <input name="produit" />
      <input type="submit" value="ajouter au caddy"/> 
    </form>
    <%=message%>
</body>
</html>