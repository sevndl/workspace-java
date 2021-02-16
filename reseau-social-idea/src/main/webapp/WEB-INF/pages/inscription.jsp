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
	<h2>Inscription</h2>
	<div class="container">
		<form action="utilisateur?action=inscription" method="post">
			<input type="text" name="username" placeholder="Nom d'utilisateur"/>
			<input type="email" name="mail" placeholder="E-mail"/>
			<input type="password" name="password" placeholder="Mot de passe">
			<br>
			<button class="btn waves-effect waves-light right" type="submit">S'inscrire</button>
		</form>
	</div>
</body>
</html>