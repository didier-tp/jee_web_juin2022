<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>resCalculTva</title>
</head>
<body>
    <%
    tp.web.model.CalculTva calculTva = (tp.web.model.CalculTva) request.getAttribute("calculTva");
    %>
    <h1>resCalculTva</h1>
    tva=<%=calculTva.getTva() %> <br/>
    ttc=<%=calculTva.getTtc() %>
</body>
</html>