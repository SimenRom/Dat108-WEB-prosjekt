<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${deltager.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${deltager.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${deltager.mobilnr}<br />
		&nbsp;&nbsp;&nbsp;
		<c:choose>
			<c:when test="${deltager.erMann()}">Mann</c:when>
			<c:when test="${deltager.erKvinne()}">Kvinne</c:when>
		</c:choose>
	</p>
	<form method="post">
	<button type="submit" class="pure-button pure-button-primary">Gå til deltagerlisten</button>
	</form>
</body>
</html>