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
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>

		<tbody>
			<c:forEach items="${deltagerliste}" var="delt">
				<c:choose>
					<c:when test="${delt.mobilnr.equals(paalogget.mobilnr)}">

						<tr bgcolor="#aaffaa">
							<td align="center">${delt.kjonn.equals("k") ? "&#9792" : "&#9794"}</td>

							<td>${paalogget.fornavn}, ${paalogget.etternavn}</td>
							<td>${paalogget.mobilnr}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr bgcolor="#ffffff">
							<td align="center">${delt.kjonn.equals("k") ? "&#9792" : "&#9794"}</td>

							<td>${delt.fornavn}, ${delt.etternavn}</td>
							<td>${delt.mobilnr}</td>
						</tr>
					</c:otherwise>
				</c:choose>
				


			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="LoggUtServlet">Ferdig/logg ut.</a>
	</p>
</body>
</html>