<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
<%@include file="commons/style.jsp"%>
</head>
<body>
	<%@include file="commons/header.jsp"%>
	<h2>Détail d'une facture</h2>
	<div class="container">
		<!-- j'utilise formatDate pour afficher la date dans un format français, avec des slash et non des tirets -->
		<h4>Date de facturation : <fmt:formatDate pattern="dd/MM/yyyy" value="${facture.getDate()}"/></h4>
		<h4>Numéro de la facture : <c:out value="${facture.getNumero()}"/></h4>
		
		<!-- je passe l'id en paramètre pour le récupérer dans la servlet et le passer aux méthodes des services -->
		<h4>Client : <a href="clients?action=detail&id=${client.getId()}"><c:out value="${client.getNom()}"/></a></h4>
		<h4>Adresse : <c:out value="${client.getAdresse()}"/></h4>
		<br>
		<table class="centered">
			<thead>
				<tr>
					<th>Article</th>
					<th>Quantité</th>
					<th>Prix (en euros)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lignes}" var="ligne">
					<tr>
						<td><c:out value="${ligne.getArticle().getNom()}"/></td>
						<td><c:out value="${ligne.getQte()}"/></td>
						<td><c:out value="${ligne.getPrix()}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3 style="text-align: right;">Coût total : <c:out value="${facture.getPrix()}"/> euros</h3>
	</div>
</body>
</html>