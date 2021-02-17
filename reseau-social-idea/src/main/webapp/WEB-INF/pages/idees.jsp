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
	<h2>Feed d'idées</h2>
	<div class="container">
		<a class="waves-effect waves-light btn" href="idee?action=ajouter">Publier une idée</a>
	</div>
	<div class="row s12">
		<c:forEach items="${idees}" var="i">
		  <div class="col s6">
	      <div class="card">
	        <div class="card-image">
						<img style="object-fit: cover;" alt="<c:out value="${i.getTitre()}"/>" src="<c:out value="${i.getImage()}"/>">
	          <span class="card-title"><c:out value="${i.getTitre()}"/></span>
	        </div>
	        <div class="card-content">
	          <p>Description : <c:out value="${i.getDescription()}"/></p>
	          <c:if test="${idee.getCategorie()}"><p>Catégorie : <c:out value="${i.getCategorie().getNom()}"/></p></c:if>
	          <c:if test="${!idee.getCategorie()}"><p>Catégorie : aucune</p></c:if>
	        </div>
	        <div class="card-action">
	          <a href="idee?action=detail&id=<c:out value="${i.getId()}"/>">En savoir plus...</a>
	        </div>
	      </div>
		  </div>
		</c:forEach>
	</div>
</body>
</html>