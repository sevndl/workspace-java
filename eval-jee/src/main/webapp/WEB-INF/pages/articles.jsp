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
	<h2>Articles</h2>
	<div class="container">
		<table class="centered">
			<thead>
				<tr>
					<th>N°</th>
					<th>Nom</th>
					<th>Prix (en euros)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${articles}" var="article">
					<tr>
						<td><c:out value="${article.getId()}"/></td>
						<td><c:out value="${article.getNom()}"/></td>
						<td><c:out value="${article.getPrix()}"/></td>
						<!-- TODO : supprimer en cascade -->
						<%-- <td>
			      	<form method="post" action="articles?action=supprimer">
			      		<input type="hidden" name="idArticle" value="<c:out value="${article.getId()}"/>"/>
			      		<input type="submit" value="Supprimer"/>
			      	</form>
						</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a class="waves-effect waves-light btn right" href="articles?action=ajouter">Ajouter un article</a>
	</div>
</body>
</html>