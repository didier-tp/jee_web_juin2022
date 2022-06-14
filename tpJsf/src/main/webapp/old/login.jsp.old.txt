<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<f:view>
    <h:messages></h:messages> <!-- affiche d'eventuels messages d'erreur -->
    <h:form>
       username: <h:inputText value="#{loginBean.username}" /> <br/>
       password: <h:inputSecret value="#{loginBean.password}" /> <br/>
       <h:commandButton value="connexion/login"
           action="#{loginBean.connexion}" />
    </h:form>
</f:view>
</body>
</html>