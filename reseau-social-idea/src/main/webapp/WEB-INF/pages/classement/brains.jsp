<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="fr.epsi.utilisateur.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
%>
<c:set var="count" value="0" scope="page"/>
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
		       			<li><a href="utilisateur?action=deconnexion">D�connexion</a></li>
		        		<li><a href="classement?action=brains">Brains</a></li>
		        		<li><a href="classement?action=tops">Tops</a></li>
		        		<li><a href="classement?action=buzz">Buzz</a></li>
		        		<li><a href="idee?action=ajouter">Ajouter une id�e</a></li>
		        		<li><a href="idee?action=liste">Feed</a></li>
	      			</c:if>
	     		</ul>
			</div>
		</nav>
		<h2>Classement Brains</h2>
		<div class="container">
			<p>Ce classement repr�sente le top 3 des utilisateurs ayant post� le plus d'id�es.</p>
			<table class="centered">
				<thead>
					<tr>
						<th>Classement</th>
						<th>Nom d'utilisateur</th>
<!-- 						<th>Nombre d'id�es propos�es</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${top}" var="u">
						<c:set var="count" value="${count + 1}" scope="page"/>
						<tr>
							<td><c:out value="${count}"></c:out></td>
							<td><c:out value="${u.getUsername()}"></c:out></td>
<%-- 							<td><c:out value="${u.getIdeesCount()}"></c:out></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<%@include file="../commons/footer.jsp"%>
</body>
</html>