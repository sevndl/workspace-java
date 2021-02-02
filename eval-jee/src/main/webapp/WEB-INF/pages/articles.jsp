<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
</head>
<body>
	<h2>Articles</h2>
	<%@include file="commons/header.jsp"%>
	<table>
		<tr>
			<td>N°</td>
			<td>Nom</td>
			<td>Prix (en euros)</td>
		</tr>
		<c:forEach items="${articles}" var="article">
			<tr>
				<td><c:out value="${article.getId()}"/></td>
				<td><c:out value="${article.getNom()}"/></td>
				<td><c:out value="${article.getPrix()}"/></td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="articles?action=ajouter">Ajouter un article</a>
</body>
</html>