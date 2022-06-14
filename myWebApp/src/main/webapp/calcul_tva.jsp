<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>calcul_tva</title>
</head>
<body>
    <%
    String sHt = request.getParameter("ht"); //null pour premier appel , pas null plus tard
    double ht = (sHt!=null)?Double.parseDouble(sHt):0;
    String sTauxTva = request.getParameter("taux_tva"); //null pour premier appel , pas null plus tard
    double tauxTva = (sTauxTva!=null)?Double.parseDouble(sTauxTva):0;
    double tva = ht * tauxTva/ 100;
    double ttc = ht + tva;
    %>
    <form  method="GET"> <!--  sans action="urlAutre" la page jsp de rappelle elle meme -->
        <label>ht:</label><input name="ht" value="<%=ht%>" /><br/>
        <label>taux_tva:</label><input name="taux_tva" value="<%=tauxTva%>" />%<br/>
        <input type="submit" value="calculer tva"/> 
    </form>
    <p>tva=<b><%=tva%></b></p>
    <p>ttc=<b><%=ttc%></b></p>
</body>
</html>