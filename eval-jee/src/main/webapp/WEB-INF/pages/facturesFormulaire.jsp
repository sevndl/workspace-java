<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		<input type="number" name="prix" placeholder="Prix de la facture"/>
		<select name="client">
			<option value="">-- Choisissez un client --</option>
			<c:forEach items="${clients}" var="client">
				<option value="<c:out value="${client.getId()}"/>"><c:out value="${client.getNom()}"/></option>
			</c:forEach>
		</select>
		<input type="date" name="dateStr"/>
		<br>
		<input type="submit" value="Ajouter"/>
	</form>
</body>
</html>