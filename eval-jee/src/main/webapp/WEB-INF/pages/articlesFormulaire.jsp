<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
</head>
<body>
	<h2>Ajouter un article</h2>
	<%@include file="commons/header.jsp"%>
	<form action="articles?action=ajouter" method="post">
		<input type="text" name="nom" placeholder="Nom de l'article"/>
		<input type="number" name="prix" placeholder="Prix de l'article"/>
		<br>
		<input type="submit" value="Ajouter"/>
	</form>
</body>
</html>