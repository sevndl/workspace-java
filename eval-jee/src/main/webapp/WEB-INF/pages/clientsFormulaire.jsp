<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
</head>
<body>
	<h2>Ajouter un client</h2>
	<%@include file="commons/header.jsp"%>
	<form action="clients?action=ajouter" method="post">
		<input type="text" name="nom" placeholder="Nom du client"/>
		<input type="text" name="adresse" placeholder="Adresse"/>
		<br>
		<input type="submit" value="Ajouter"/>
	</form>
</body>
</html>