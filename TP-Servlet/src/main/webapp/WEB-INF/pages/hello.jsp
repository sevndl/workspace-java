<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web app</title>
</head>
<body>
	<h3 style='color:red'>Titre</h3>
	<p>Bonjour <c:out value = "${client}"/></p>
</body>
</html>