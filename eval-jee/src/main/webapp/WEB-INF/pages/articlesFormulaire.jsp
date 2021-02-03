<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
<%@include file="commons/style.jsp"%>
</head>
<body>
	<%@include file="commons/header.jsp"%>
	<h2>Ajouter un article</h2>
	<div class="container">
		<form action="articles" method="post">
			<input type="text" name="nom" placeholder="Nom de l'article"/>
			<input type="number" name="prix" placeholder="Prix de l'article"/>
			<br>
			<button class="btn waves-effect waves-light right" type="submit">Ajouter</button>
		</form>
	</div>
</body>
</html>