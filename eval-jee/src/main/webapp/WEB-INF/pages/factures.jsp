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
<div>
	<%@include file="commons/header.jsp"%>
	<h2>Factures</h2>
	<div class="container">
		<table class="centered">
			<thead>
				<tr>
					<th>N°</th>
					<th>Date</th>
					<th>Client</th>
					<th>Prix (en euros)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${factures}" var="facture">
					<tr>
						<!-- je passe l'id en paramètre pour le récupérer dans la servlet et le passer aux méthodes des services -->
						<td><a href='factures?action=detail&id=${facture.getId()}'><c:out value="${facture.getNumero()}"/></a></td>
						<!-- j'utilise formatDate pour afficher la date dans un format français, avec des slash et non des tirets -->
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${facture.getDate()}"/></td>
						<td><c:out value="${facture.getClient().getNom()}"/></td>
						<td><c:out value="${facture.getPrix()}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a class="waves-effect waves-light btn right" href="factures?action=ajouter">Ajouter une facture</a>
	</div>
</div>
</body>
</html>