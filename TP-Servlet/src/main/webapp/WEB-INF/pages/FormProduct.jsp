<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web app</title>
<%@include file="commons/header.jsp" %>
</head>
<body>
<div class="container">
	<%@include file="commons/nav.jsp" %>
	<form action="produit" method="post">
		<label for="nomProduit">Nom produit</label> <input type="text" name="nomProduit"><br>
		<label for="cbProduit">Code barre</label> <input type="text" name="cbProduit"><br>
		<input type="hidden" name="actionPost" value="formCreate">
		<input type="submit" value="Valider">
	</form>
</div>
</body>
</html>