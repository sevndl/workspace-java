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
	<h2>Connexion</h2>
	<div class="container">
		<form action="utilisateur?action=connexion" method="post">
			<input type="email" name="mail" placeholder="E-mail"/>
			<input type="password" name="password" placeholder="Mot de passe">
			<br>
			<button class="btn waves-effect waves-light right" type="submit">Se connecter</button>
		</form>
	</div>
</body>
</html>