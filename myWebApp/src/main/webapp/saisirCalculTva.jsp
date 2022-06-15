<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>saisirCalculTva</title>
</head>
<body>
       <%@ include file="entete.jsp" %>
     <h1>saisirCalculTva</h1>
     <form  action="MvcServlet" method="POST">
        <input type="hidden" name="tache" value="calculTva"/>
        <label>ht:</label><input name="ht" value="${calculTva.ht}" /><br/>
        <label>taux_tva:</label><input name="taux_tva"  value="${calculTva.tauxTva}" />%<br/>
        <input type="submit" value="calculer tva"/> 
    </form>
    <p>${calculTva.message}</p>
</body>
</html>