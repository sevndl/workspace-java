<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="fr.epsi.utilisateur.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../commons/title.jsp"%>
<%@include file="../commons/style.jsp"%>
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
		        		<li><a href="classement?action=brains">Brains</a></li>
		        		<li><a href="classement?action=tops">Tops</a></li>
		        		<li><a href="classement?action=buzz">Buzz</a></li>
		        		<li><a href="idee?action=liste">Feed</a></li>
		   			</c:if>
		   			<c:if test="<%= user != null %>">
		   				<li><c:out value="<%= user.getUsername() %>"></c:out></li>
		       			<li><a href="utilisateur?action=deconnexion">Déconnexion</a></li>
		        		<li><a href="classement?action=brains">Brains</a></li>
		        		<li><a href="classement?action=tops">Tops</a></li>
		        		<li><a href="classement?action=buzz">Buzz</a></li>
		        		<li><a href="idee?action=ajouter">Ajouter une idée</a></li>
		        		<li><a href="idee?action=liste">Feed</a></li>
	      			</c:if>
	     		</ul>
			</div>
		</nav>
		<h2>Connexion</h2>
		<div class="container">
			<h3 class="erreur">Erreur lors de la connexion.</h3>
			<form action="utilisateur?action=connexion" method="post">
				<input type="email" name="mail" placeholder="E-mail"/>
				<input type="password" name="password" placeholder="Mot de passe">
				<br>
				<button class="btn waves-effect waves-light right" type="submit">Se connecter</button>
			</form>
		</div>
	</div>
	<%@include file="../commons/footer.jsp"%>
</body>
</html>