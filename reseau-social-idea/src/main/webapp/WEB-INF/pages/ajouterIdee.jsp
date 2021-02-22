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
		<h2>Publier une idée</h2>
		<div class="container">
			<form action="idee?action=ajouter" method="post">
				<input type="text" name="titre" placeholder="Titre"/>
				<input type="text" name="description" placeholder="Description"/>
				<input type="text" name="image" placeholder="Url de l'image">
				<select name="categorie" class="browser-default">
					<option value="">## Choisir une catégorie ##</option>
					<c:forEach items="${categories}" var="c">
						<option value="<c:out value="${c.getId()}"/>"><c:out value="${c.getNom()}"/></option>
					</c:forEach>
				</select>
				<br>
				<button class="btn waves-effect waves-light right" type="submit">Publier</button>
			</form>
		</div>
	</div>
	<%@include file="commons/footer.jsp"%>
</body>
</html>