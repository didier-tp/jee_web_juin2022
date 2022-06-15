<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>resCalculTva</title>
</head>
<body>
      <%@ include file="entete.jsp" %>
    <h1>resCalculTva</h1>
    tva=<b>${calculTva.tva}</b> <br/>
    ttc=<b>${calculTva.ttc}</b> <br/>
    
  
     ttc en scope request =<b>${requestScope.calculTva.ttc}</b> <br/>
     ttc en scope session =<b>${sessionScope.calculTva.ttc}</b> <br/>
</body>
</html>