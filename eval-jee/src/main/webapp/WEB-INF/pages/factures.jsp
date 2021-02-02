<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
</head>
<body>
	<h2>Factures</h2>
	<%@include file="commons/header.jsp"%>
	<table>
		<tr>
			<td>N°</td>
			<td>Date</td>
			<td>Prix (en euros)</td>
		</tr>
		<c:forEach items="${factures}" var="facture">
			<tr>
				<td><c:out value="${facture.getNumero()}"/></td>
				<td><fmt:formatDate pattern = "dd/MM/yyyy" value="${facture.getDate()}"/></td>
				<td><c:out value="${facture.getPrix()}"/></td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="factures?action=ajouter">Ajouter une facture</a>
</body>
</html>