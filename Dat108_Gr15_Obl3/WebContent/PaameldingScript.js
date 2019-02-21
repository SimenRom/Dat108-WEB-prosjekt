
let passord;
function fornavnSjekk() {
	let fn = document.getElementById("fn");
	let fornavn = document.getElementById("fornavn").value;
	if (fornavn.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{1,19}$")){
		fn.innerHTML = "";
	} else {
		fn.innerHTML = "Ugyldig";
	}
}

function etternavnSjekk() {
	let en = document.getElementById("en");
	let etternavn = document.getElementById("etternavn").value;
	if (etternavn.match("^[A-ZÆØÅ][A-Za-zÆØÅæøå\\-]{1,19}$")) {
		en.innerHTML = "";
	} else {
		en.innerHTML = "Ugyldig";
	}
}
function mobilSjekk() {
	let mob = document.getElementById("mob");
	let mobil = document.getElementById("mobil").value;
	if (mobil.match("^[\\d]{8}$")) {
		mob.innerHTML = "";
	} else {
		mob.innerHTML = "Ugyldig";
	}
}
function passordSjekk() {
	let pass = document.getElementById("pass");
	passord = document.getElementById("passord").value;
	if (passord.match("^.{8,}$")) {
		pass.innerHTML = "";
	} else {
		pass.innerHTML = "Ugyldig";
	}
}
function passordRepSjekk() {
	let passRep = document.getElementById("passRep");
	let passordRep = document.getElementById("passordRep").value;
	if (passordRep === passord) {
		passRep.innerHTML = "";
	} else {
		passRep.innerHTML = "Ugyldig";
	}
}
