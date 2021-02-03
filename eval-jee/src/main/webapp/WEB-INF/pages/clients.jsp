<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
<%@include file="commons/style.jsp"%>
</head>
<body>
	<%@include file="commons/header.jsp"%>
	<h2>Clients</h2>
	<div class="container">
		<table class="centered">
			<thead>
				<tr>
					<th>N°</th>
					<th>Nom</th>
					<th>Adresse</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clients}" var="client">
					<tr>
						<td><c:out value="${client.getId()}"/></td>
						<!-- je passe l'id en paramètre pour le récupérer dans la servlet et le passer aux méthodes des services -->
						<td><a href="clients?action=detail&id=${client.getId()}"><c:out value="${client.getNom()}"/></a></td>
						<td><c:out value="${client.getAdresse()}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a class="waves-effect waves-light btn right" href="clients?action=ajouter">Ajouter un client</a>
	</div>
</body>
</html>