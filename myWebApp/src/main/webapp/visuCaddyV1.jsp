<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>visuCaddy</title>
</head>
<body>
   <%
   List<String> caddy = (List<String>) session.getAttribute("caddy");
   %>
   <h1>visuCaddy</h1>
   
  <%if(caddy!=null)
     { %> 
   <table border="1">
      <%for(String element : caddy){ %>
     <tr><td><%=element%></td></tr> 
     <%}%>
   </table>
   <%}%>
   
   <p><a href="index.html">retour index</a></p>
   <p>num de session (HttpSession java) : <%=session.getId() %></p>
</body>
</html>