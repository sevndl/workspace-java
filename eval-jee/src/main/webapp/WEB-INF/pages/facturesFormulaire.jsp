<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
<%@include file="commons/style.jsp"%>
</head>
<body>
	<%@include file="commons/header.jsp"%>
	<h2>Ajouter une facture</h2>
	<div class="container">
		<form action="factures?action=ajouter" method="post">
			<input type="text" name="numero" placeholder="Numéro de la facture"/>
			<br>
			<select name="client" class="browser-default">
				<option value="">-- Choisissez un client --</option>
				<c:forEach items="${clients}" var="client">
					<option value="<c:out value="${client.getId()}"/>"><c:out value="${client.getNom()}"/></option>
				</c:forEach>
			</select>
			<br>
			<div>
				<select name="article1" class="browser-default">
					<option value="">-- Choisissez un article --</option>
					<c:forEach items="${articles}" var="article">
						<option value="<c:out value="${article.getId()}"/>"><c:out value="${article.getNom()}"/> (<c:out value="${article.getPrix()}"/>)</option>
					</c:forEach>
				</select>
			</div>
			<input type="number" name="qte1" placeholder="Quantité"/>
			<br>
			<select name="article2" class="browser-default">
				<option value="">-- Choisissez un article --</option>
				<c:forEach items="${articles}" var="article">
					<option value="<c:out value="${article.getId()}"/>"><c:out value="${article.getNom()}"/> (<c:out value="${article.getPrix()}"/>)</option>
				</c:forEach>
			</select>
			<input type="number" name="qte2" placeholder="Quantité"/>
			<br>
			<select name="article3" class="browser-default">
				<option value="">-- Choisissez un article --</option>
				<c:forEach items="${articles}" var="article">
					<option value="<c:out value="${article.getId()}"/>"><c:out value="${article.getNom()}"/> (<c:out value="${article.getPrix()}"/>)</option>
				</c:forEach>
			</select>
			<input type="number" name="qte3" placeholder="Quantité"/>
			<br>
			<select name="article4" class="browser-default">
				<option value="">-- Choisissez un article --</option>
				<c:forEach items="${articles}" var="article">
					<option value="<c:out value="${article.getId()}"/>"><c:out value="${article.getNom()}"/> (<c:out value="${article.getPrix()}"/>)</option>
				</c:forEach>
			</select>
			<input type="number" name="qte4" placeholder="Quantité"/>
			<br>
			<input type="date" name="dateStr"/>
			<br>
			<button class="btn waves-effect waves-light right" type="submit">Ajouter</button>
		</form>
	</div>
</body>
</html>