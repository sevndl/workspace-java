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
	<h2>Publier une id�e</h2>
	<div class="container">
		<form action="idee?action=ajouter" method="post">
			<input type="text" name="titre" placeholder="Titre"/>
			<input type="text" name="description" placeholder="Description"/>
			<input type="text" name="image" placeholder="Url de l'image">
			<select name="categorie" class="browser-default">
				<option value="">## Choisir une cat�gorie ##</option>
				<c:forEach items="${categories}" var="c">
					<option value="<c:out value="${c.getId()}"/>"><c:out value="${c.getNom()}"/></option>
				</c:forEach>
			</select>
			<br>
			<button class="btn waves-effect waves-light right" type="submit">Publier</button>
		</form>
	</div>
</body>
</html>