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
	       			<li><a href="utilisateur?action=deconnexion">Déconnexion</a></li>
	        		<li><a href="idee?action=liste">Feed</a></li>
	        		<li><a href="idee?action=ajouter">Ajouter une idée</a></li>
      			</c:if>
     		</ul>
		</div>
	</nav>
  	<a class="btn-floating btn-large waves-effect waves-light" href="idee?action=liste"><</a>
	<h2><c:out value="${idee.getTitre()}"/></h2>
	<div class="container">
		<img style="max-width: 100%;" alt="<c:out value="${idee.getTitre()}"/>" src="<c:out value="${idee.getImage()}"/>">
    	<div>
		    <p><c:out value="${idee.getDescription()}"/></p>
		    <h6>
		    	Publiée par 
		    	<c:if test="${idee.getUtilisateur() != null}"><c:out value="${idee.getUtilisateur().getUsername()}"/></c:if>
		    	<c:if test="${idee.getUtilisateur() == null}">anonyme</c:if>
		    </h6>
		    <h6>
		    	Publiée <c:if test="${idee.getDate() != null}">le <c:out value="${idee.getDate()}"/></c:if>
		    	<c:if test="${idee.getDate() == null}">on ne sait pas quand :(</c:if>
	    	</h6>
	    </div>
	    <hr>
	    <h3>Commentaires :</h3>
	    <div>
	    	<c:forEach items="${commentaires}" var="commentaire">
	    		<h5>
	    			Posté par 
	    				<c:if test="${commentaire.getAuteur() != null}"><c:out value="${commentaire.getAuteur().getUsername()}"/>,</c:if>
	    				<c:if test="${commentaire.getAuteur() == null}">anonyme,</c:if>
	    				<c:if test="${commentaire.getDateCreation() != null}">le <c:out value="${commentaire.getDateCreation()}"/>.</c:if>
	    				<c:if test="${commentaire.getDateCreation() == null}">on ne sait pas quand :(</c:if>
	    		</h5>
	    		<p><c:out value="${commentaire.getContenu()}"/></p>
	    		<br><br>
	    	</c:forEach>
	    </div>
	    <c:if test="<%= user != null %>">
		    <div>
		    	<form action="idee?action=commentaire" method="post">
		    		<textarea name="commentaire" rows="2" cols="120" placeholder="Commentaire..."></textarea>
		    		<input type="hidden" name="id" value="${idee.getId()}"/>
		    		<button class="btn waves-effect waves-light right" type="submit">Envoyer</button>
		    	</form>
	    	</div>
    	</c:if>
    	<c:if test="<%= user == null %>">
    		<h6>Vous devez être connecté pour pouvoir poster un commentaire.</h6>
    		<a href="utilisateur?action=connexion">Se connecter</a>
    		<br>
    		<a href="utilisateur?action=inscription">S'inscrire</a>
    	</c:if>
	</div>
</body>
</html>