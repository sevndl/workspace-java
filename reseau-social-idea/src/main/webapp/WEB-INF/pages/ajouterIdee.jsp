<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
<%@include file="commons/style.jsp"%>
</head>
<body>
	<%@include file="commons/header.jsp"%>
	<h2>Publier une idée</h2>
	<div class="container">
		<form action="idee?action=ajouter" method="post">
			<input type="text" name="titre" placeholder="Titre"/>
			<input type="text" name="description" placeholder="Description"/>
			<input type="text" name="image" placeholder="Url de l'image">
			<br>
			<button class="btn waves-effect waves-light right" type="submit">Publier</button>
		</form>
	</div>
</body>
</html>