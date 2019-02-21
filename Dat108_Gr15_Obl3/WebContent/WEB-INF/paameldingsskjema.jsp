<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmelding</title>
</head>
<body>

	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input type="text"
					name="fornavn" id="fornavn" value="${skjema.fornavn}"
					onkeyup="fornavnSjekk()" /> <font color="red" id="fn">${skjema.fornavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input type="text"
					name="etternavn" id="etternavn" value="${skjema.etternavn}"
					onkeyup="etternavnSjekk()" /> <font color="red" id="en">${skjema.etternavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input type="text"
					name="mobil" id="mobil" value="${skjema.telefon}"
					onkeyup="mobilSjekk()" /> <font id="mob" color="red">${skjema.telefonFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" id="passord" value="${skjema.passord}"
					onkeyup="passordSjekk()" /> <font id="pass" color="red">${skjema.passordFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Repeter Passord:</label> <input
					type="password" id="passordRep" name="passordRepetert"
					value="${skjema.passordKopi}" onkeyup="passordRepSjekk()" /> <font
					color="red" id="passRep">${skjema.passordKopiFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" ${skjema.kjonn.equals("mann") ? "checked" : ""} />mann
				<input type="radio" name="kjonn" value="kvinne"
					${skjema.kjonn.equals("kvinne") ? "checked" : ""} />kvinne
				<font color="red">${skjema.kjonnFeilmelding}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
	<script src="PaameldingScript.js">
		
	</script>
</body>
</html>