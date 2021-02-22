<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="fr.epsi.utilisateur.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="commons/title.jsp"%>
<%@include file="commons/style.jsp"%>
</head>
<body>
	<div class="content">
		<nav>
		   	<div class="nav-wrapper">
	     		<a href="home" class="brand-logo left" style="margin-left: 20px">Home</a>
		   		<ul id="nav-mobile" class="right hide-on-med-and-down" style="margin-right: 20px">
		   			<c:if test="<%= user == null %>">
		       			<li><a href="utilisateur?action=connexion">Connexion</a></li>
		        		<li><a href="utilisateur?action=inscription">Inscription</a></li>
		        		<li><a href="idee?action=liste">Feed</a></li>
		   			</c:if>
		   			<c:if test="<%= user != null %>">
		   				<li><c:out value="<%= user.getUsername() %>"></c:out></li>
		       			<li><a href="utilisateur?action=deconnexion">Déconnexion</a></li>
		        		<li><a href="idee?action=ajouter">Ajouter une idée</a></li>
		        		<li><a href="idee?action=liste">Feed</a></li>
	      			</c:if>
	     		</ul>
			</div>
		</nav>
		<h2>Feed d'idées</h2>
		<div class="container">
			<c:if test="<%= user == null %>">
	    		<h6>Vous devez être connecté pour pouvoir publier une idée.</h6>
	    		<a href="utilisateur?action=connexion">Se connecter</a>
	    		<br>
	    		<a href="utilisateur?action=inscription">S'inscrire</a>
	    	</c:if>
	    	<c:if test="<%= user != null %>">
				<a class="waves-effect waves-light btn" href="idee?action=ajouter">Publier une idée</a>    	
	    	</c:if>
		</div>
		<div class="row s12">
			<c:forEach items="${idees}" var="i">
				<div class="col s6">
			    	<div class="card">
			        	<div class="card-image">
							<a href="idee?action=detail&id=<c:out value="${i.getId()}"/>"><img style="object-fit: contains;" width="800px" height="500px" alt="<c:out value="${i.getTitre()}"/>" src="<c:out value="${i.getImage()}"/>"></a>
			          		<span class="card-title"><c:out value="${i.getTitre()}"/></span>
			        	</div>
			        	<div class="card-content">
			          		<p>Description : <c:out value="${i.getDescription()}"/></p>
			          		<p>
			          			Catégorie : 
			          			<c:if test="${i.getCategorie() != null}"><c:out value="${i.getCategorie().getNom()}"/></c:if>
			          			<c:if test="${i.getCategorie() == null}"> aucune</c:if>
	          				</p>
			        	</div>
			        	<div class="card-action">
			          		<a href="idee?action=detail&id=<c:out value="${i.getId()}"/>">En savoir plus...</a>
		        		</div>
			      	</div>
			  	</div>
			</c:forEach>
		</div>
	</div>
	<%@include file="commons/footer.jsp"%>
</body>
</html>