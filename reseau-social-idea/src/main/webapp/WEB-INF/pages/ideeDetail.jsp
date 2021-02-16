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
  <a class="btn-floating btn-large waves-effect waves-light" href="idee?action=liste"><</a>
	<h2><c:out value="${idee.getTitre()}"/></h2>
	<div class="container">
		<div>
			<img style="max-width: 100%;" alt="<c:out value="${idee.getTitre()}"/>" src="<c:out value="${idee.getImage()}"/>">
	    <div>
		    <p><c:out value="${idee.getDescription()}"/></p>
		    <h6>
		    	Publiée par 
		    	<c:if test="${idee.getUtilisateur()}"><c:out value="${idee.getUtilisateur()}"/></c:if>
		    	<c:if test="${!idee.getUtilisateur()}">anonyme</c:if>
		    </h6>
		    <h6>
		    	Publiée <c:if test="${idee.getDate()}">le <c:out value="${idee.getDate()}"/></c:if>
		    	<c:if test="${!idee.getUtilisateur()}">on ne sait pas quand :(</c:if>
	    	</h6>
	    </div>
		</div>
	</div>
</body>
</html>