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
	<h2>D�tail d'un client</h2>
	<%@include file="commons/header.jsp"%>
	<h4>Nom : <c:out value="${client.getNom()}"/></h4>
	<h4>Adresse : <c:out value="${client.getAdresse()}"/></h4>
	<hr>
	<table>
		<tr>
			<td>Num�ro</td>
			<td>Date</td>
			<td>Prix (en euros)</td>
		</tr>
		<c:forEach items="${factures}" var="facture">
			<tr>
				<!-- je passe l'id en param�tre pour le r�cup�rer dans la servlet et le passer aux m�thodes des services -->
				<td><a href='factures?action=detail&id=${facture.getId()}'><c:out value="${facture.getNumero()}"/></a></td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${facture.getDate()}"/></td>
				<td><c:out value="${facture.getPrix()}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>