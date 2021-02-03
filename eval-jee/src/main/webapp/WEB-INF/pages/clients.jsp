<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
</head>
<body>
	<h2>Clients</h2>
	<%@include file="commons/header.jsp"%>
	<table>
		<tr>
			<td>N°</td>
			<td>Nom</td>
			<td>Adresse</td>
		</tr>
		<c:forEach items="${clients}" var="client">
			<tr>
				<td><c:out value="${client.getId()}"/></td>
				<!-- je passe l'id en paramètre pour le récupérer dans la servlet et le passer aux méthodes des services -->
				<td><a href="clients?action=detail&id=${client.getId()}"><c:out value="${client.getNom()}"/></a></td>
				<td><c:out value="${client.getAdresse()}"/></td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="clients?action=ajouter">Ajouter un client</a>
</body>
</html>