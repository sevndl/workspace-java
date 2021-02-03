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
	<h2>Ajouter un client</h2>
	<div class="container">
		<form action="clients?action=ajouter" method="post">
			<input type="text" name="nom" placeholder="Nom du client"/>
			<input type="text" name="adresse" placeholder="Adresse : 1234 rue du professeur Toto 12345 Toto"/>
			<br>
			<button class="btn waves-effect waves-light right" type="submit">Ajouter</button>
		</form>
	</div>
</body>
</html>