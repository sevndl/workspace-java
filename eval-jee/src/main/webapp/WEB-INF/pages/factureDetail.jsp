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
	<h3>Coût total : <c:out value="${facture.getPrix()}"/></h3>
	
	<h4>Client : <c:out value="${client.getNom()}"/></h4>
	<h4>Adresse : <c:out value="${client.getAdresse()}"/></h4>
	<hr>
	<table>
		<tr>
			<td>Article</td>
			<td>Quantité</td>
			<td>Prix (en euros)</td>
		</tr>
		<c:forEach items="${lignes}" var="ligne">
			<tr>
				<td><c:out value="${ligne.getArticle().getNom()}"/></td>
				<td><c:out value="${ligne.getQte()}"/></td>
				<td><c:out value="${ligne.getPrix()}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>