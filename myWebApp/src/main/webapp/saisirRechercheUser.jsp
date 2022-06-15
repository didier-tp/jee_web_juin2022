<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>saisirRechercheUser</title>
</head>
<body>
      <%@ include file="entete.jsp" %>
     <h1>saisirRechercheUser</h1>
     <form  action="MvcServlet" method="POST">
        <input type="hidden" name="tache" value="rechercheUser"/>
        <label>id:</label><input name="id"  /><br/>
        <input type="submit" value="rechercher User"/> 
    </form>
    <p>${userBean.message}</p>
</body>
</html>