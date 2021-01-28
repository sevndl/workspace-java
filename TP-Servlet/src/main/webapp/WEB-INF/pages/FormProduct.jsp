<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web app</title>
<style>
	a {
		margin: 10px 10px;
	}
</style>
<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
	<a href="home">Home</a>
	<a href="produit">Ajouter un produit</a>
	<hr>
	<form action="produit" method="post">
		<label for="nomProduit">Nom produit</label> <input type="text" name="nomProduit"><br>
		<label for="cbProduit">Code barre</label> <input type="text" name="cbProduit"><br>
		<input type="submit" value="Valider">
	</form>
</div>
</body>
</html>