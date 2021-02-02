<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
</head>
<body>
	<h2>Ajouter une facture</h2>
	<%@include file="commons/header.jsp"%>
	<form action="factures?action=ajouter" method="post">
		<input type="text" name="numero" placeholder="Numéro de la facture"/>
		<input type="text" name="prix" placeholder="Prix de la facture"/>
		<input type="date" name="dateStr"/>
		<br>
		<input type="submit" value="Ajouter"/>
	</form>
</body>
</html>