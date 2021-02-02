<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
</head>
<body>
	<h2>Factures</h2>
	<%@include file="commons/header.jsp"%>
	<h4>Date de facturation : <fmt:formatDate pattern="dd/MM/yyyy" value="${facture.getDate()}"/></h4>
	<h4>Numéro de la facture : <c:out value="${facture.getNumero()}"/></h4>
	<h2>Coût total : <c:out value="${facture.getPrix()}"/></h2>
</body>
</html>