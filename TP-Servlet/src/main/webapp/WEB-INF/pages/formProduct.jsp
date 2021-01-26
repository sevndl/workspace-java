<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web app</title>
</head>
<body>
	<form action="produit" method="post">
		<label for="nomProduit">Nom produit</label> <input type="text" name="nomProduit">
		<label for="cbProduit">Code barre</label> <input type="text" name="cbProduit">
		<input type="submit" value="Valider">
	</form>
</body>
</html>