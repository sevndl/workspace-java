<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web app</title>
</head>
<body>
	<ul>
		<li><a href="home">Home</a></li>
		<li><a href="produit">Ajouter un produit</a></li>
	</ul>
	<hr>
	<form action="produit" method="post">
		<label for="nomProduit">Nom produit</label> <input type="text" name="nomProduit"><br>
		<label for="cbProduit">Code barre</label> <input type="text" name="cbProduit"><br>
		<input type="submit" value="Valider">
	</form>
</body>
</html>