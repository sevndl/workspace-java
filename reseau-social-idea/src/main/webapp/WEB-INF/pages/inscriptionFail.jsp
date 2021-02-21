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
	       			<li><a href="utilisateur?action=deconnexion">D�connexion</a></li>
	        		<li><a href="idee?action=liste">Feed</a></li>
	        		<li><a href="idee?action=ajouter">Ajouter une id�e</a></li>
      			</c:if>
     		</ul>
		</div>
	</nav>
	<h2>Inscription</h2>
	<div class="container">
		<h3 class="erreur">Erreur lors de l'inscription.</h3>
		<form action="utilisateur?action=inscription" method="post">
			<input type="text" name="username" placeholder="Nom d'utilisateur"/>
			<input type="email" name="mail" placeholder="E-mail"/>
			<input type="password" name="password" placeholder="Mot de passe">
			<br>
			<button class="btn waves-effect waves-light right" type="submit">S'inscrire</button>
		</form>
	</div>
</body>
</html>